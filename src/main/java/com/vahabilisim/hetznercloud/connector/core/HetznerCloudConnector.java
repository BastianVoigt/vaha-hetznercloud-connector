package com.vahabilisim.hetznercloud.connector.core;

import com.vahabilisim.hetznercloud.connector.request.HttpMethod;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vahabilisim.hetznercloud.connector.model.common.Meta;
import com.vahabilisim.hetznercloud.connector.request.AbstractRequest;
import com.vahabilisim.hetznercloud.connector.request.getall.AbstractGetAll;
import com.vahabilisim.hetznercloud.connector.response.ResponsePaginatedList;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class HetznerCloudConnector {

    private static final ObjectMapper OBJ_MAPPER = new ObjectMapper();

    static {
        OBJ_MAPPER.setDateFormat(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX"));
    }

    private static final String HTTP_API_BASE = "https://api.hetzner.cloud/v1";
    private static final int HTTP_CONNECT_TIMEOUT = 5000;
    private static final int HTTP_READ_TIMEOUT = 10000;

    private static final String HEADER_CONTENT_LEN = "Content-Length";

    private final Object REQUEST_MUTEX = new Object();
    private final Map<String, String> headers;

    public HetznerCloudConnector(String token) {
        headers = new HashMap<>();
        headers.put("Accept", "application/json;charset=UTF-8");
        headers.put("Content-Type", "application/json;charset=UTF-8");
        headers.put("Authorization", String.format("Bearer %s", token));
    }

    public <T> T request(AbstractRequest<T> req) throws ConnectorException {
        return performRequestResponse(req.getResponseClass(), req.getHttpMethod(), req.getEndPoint(), req.getJsonKey(), req.getPostData());
    }

    public <T extends ResponsePaginatedList> T requestAll(AbstractGetAll<T> req) throws ConnectorException {
        final T retVal = performRequestResponse(req.getResponseClass(), req.getHttpMethod(), req.getEndPoint(), req.getJsonKey(), req.getPostData());
        T response = retVal;
        while (null != (response = requestNext(req, response.getMeta().getPagination()))) {
            retVal.getList().addAll(response.getList());
        }
        retVal.setMeta(null);
        return retVal;
    }

    public <T extends ResponsePaginatedList> T requestPrevious(AbstractGetAll<T> req, Meta.Pagination currentPage) throws ConnectorException {
        if (false == currentPage.hasPrevious()) {
            return null;
        }
        final String endPoint = String.format("%s?page=%d", req.getEndPoint(), currentPage.getPreviousPage());
        return performRequestResponse(req.getResponseClass(), req.getHttpMethod(), endPoint, req.getJsonKey(), req.getPostData());
    }

    public <T extends ResponsePaginatedList> T requestNext(AbstractGetAll<T> req, Meta.Pagination currentPage) throws ConnectorException {
        if (false == currentPage.hasNext()) {
            return null;
        }
        final String endPoint = String.format("%s?page=%d", req.getEndPoint(), currentPage.getNextPage());
        return performRequestResponse(req.getResponseClass(), req.getHttpMethod(), endPoint, req.getJsonKey(), req.getPostData());
    }

    private <T> T performRequestResponse(Class<T> clazz, HttpMethod method, String endPoint, String jsonKey, Object postData) throws ConnectorException {
        synchronized (REQUEST_MUTEX) {
            HttpURLConnection conn = null;
            try {
                conn = getConnection(method, endPoint, postData);
                return getResponseData(conn, clazz, jsonKey);
            } finally {
                releaseConnection(conn);
            }
        }
    }

    private HttpURLConnection getConnection(HttpMethod method, String endPoint, Object postData) throws ConnectorException {
        try {
            final HttpURLConnection conn = (HttpURLConnection) new URL(String.format("%s/%s", HTTP_API_BASE, endPoint)).openConnection();
            headers.forEach((key, val) -> {
                conn.setRequestProperty(key, val);
            });
            conn.setRequestMethod(method.name());
            conn.setConnectTimeout(HTTP_CONNECT_TIMEOUT);
            conn.setReadTimeout(HTTP_READ_TIMEOUT);
            conn.setUseCaches(false);

            if (null != postData) {
                System.out.println("POST: " + OBJ_MAPPER.writeValueAsString(postData));
                final byte[] output = OBJ_MAPPER.writeValueAsBytes(postData);
                conn.setRequestProperty(HEADER_CONTENT_LEN, String.valueOf(output.length));
                conn.setDoOutput(true);
                conn.getOutputStream().write(output);
            }

            return conn;

        } catch (IOException ex) {
            throw new ConnectorException(ConnectorError.builder()
                    .code(ConnectorError.Code.HTTP_ERROR)
                    .message("IO problem occurred")
                    .build(), ex);
        }
    }

    private <T> T getResponseData(HttpURLConnection conn, Class<T> clazz, String jsonKey) throws ConnectorException {
        try {

            final JsonNode jsonNode = OBJ_MAPPER.readTree(
                    new InputStreamReader(
                            conn.getResponseCode() < HttpURLConnection.HTTP_BAD_REQUEST
                            ? conn.getInputStream()
                            : conn.getErrorStream(),
                            "UTF-8"));
            if (null == jsonNode && false == Void.class.equals(clazz)) {
                throw new ConnectorException(ConnectorError.builder()
                        .code(ConnectorError.Code.HTTP_ERROR)
                        .message("Response data NULL")
                        .build());
            }

            final JsonNode jsonError = Optional.ofNullable(jsonNode)
                    .map(node -> node.get("error"))
                    .orElse(null);
            if (null != jsonError) {
                throw new ConnectorException(OBJ_MAPPER.convertValue(jsonError, ConnectorError.class));
            }

            final JsonNode jsonData = Optional.ofNullable(jsonNode)
                    .map(node -> node.get(jsonKey))
                    .orElse(null);
            if (null != jsonKey && null == jsonData) {
                throw new ConnectorException(ConnectorError.builder()
                        .code(ConnectorError.Code.HTTP_ERROR)
                        .message("Response and expected object inconsistency")
                        .build());
            }

            // if jsonKey is null, then the response itself should be handled as JSON formatted data
            // otherwise the value corresponding to jsonKey should be handled as JSON formatted data
            return OBJ_MAPPER.convertValue(null == jsonKey ? jsonNode : jsonData, clazz);

        } catch (IOException ex) {
            throw new ConnectorException(ConnectorError.builder()
                    .code(ConnectorError.Code.HTTP_ERROR)
                    .message("IO problem occurred")
                    .build(), ex);
        }
    }

    private void releaseConnection(HttpURLConnection conn) {
        Optional.ofNullable(conn)
                .ifPresent(c -> {
                    c.disconnect();
                });
    }
}
