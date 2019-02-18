package com.vahabilisim.hetznercloud.connector.request.getall;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.vahabilisim.hetznercloud.connector.model.main.ServerType;
import com.vahabilisim.hetznercloud.connector.response.ResponsePaginatedList;
import java.util.List;

public class GetServerTypes extends AbstractGetAll<GetServerTypes.ResponseServerTypes> {

    public GetServerTypes() {
        super(ResponseServerTypes.class);
    }

    @Override
    public String getEndPoint() {
        return "server_types";
    }

    public static class ResponseServerTypes extends ResponsePaginatedList<ServerType> {

        @JsonProperty("server_types")
        public void setServerTypes(List<ServerType> list) {
            setList(list);
        }
    }
}
