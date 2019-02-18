package com.vahabilisim.hetznercloud.connector.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties({"httpMethod", "endPoint", "jsonKey", "postData", "responseClass"})
public abstract class AbstractRequest<T> {

    public abstract HttpMethod getHttpMethod();

    public abstract String getEndPoint();

    public abstract String getJsonKey();

    public abstract Object getPostData();

    private final Class<T> responseClass;

    public AbstractRequest(Class<T> responseClass) {
        this.responseClass = responseClass;
    }

    public final Class<T> getResponseClass() {
        return responseClass;
    }
}
