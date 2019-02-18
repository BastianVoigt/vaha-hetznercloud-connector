package com.vahabilisim.hetznercloud.connector.request.get;

import com.vahabilisim.hetznercloud.connector.model.main.Server;

public class GetServer extends AbstractGet<Server> {

    public GetServer(long id) {
        super(Server.class, id);
    }

    @Override
    public String getEndPoint() {
        return String.format("servers/%d", id);
    }

    @Override
    public String getJsonKey() {
        return "server";
    }
}
