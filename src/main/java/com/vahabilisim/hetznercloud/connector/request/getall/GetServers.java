package com.vahabilisim.hetznercloud.connector.request.getall;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.vahabilisim.hetznercloud.connector.model.main.Server;
import com.vahabilisim.hetznercloud.connector.response.ResponsePaginatedList;
import java.util.List;

public class GetServers extends AbstractGetAll<GetServers.ResponseServers> {

    public GetServers() {
        super(ResponseServers.class);
    }

    @Override
    public String getEndPoint() {
        return "servers";
    }

    public static class ResponseServers extends ResponsePaginatedList<Server> {

        @JsonProperty("servers")
        public void setServers(List<Server> list) {
            setList(list);
        }
    }
}
