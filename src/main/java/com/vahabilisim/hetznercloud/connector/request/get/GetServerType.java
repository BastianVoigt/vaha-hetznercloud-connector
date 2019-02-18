package com.vahabilisim.hetznercloud.connector.request.get;

import com.vahabilisim.hetznercloud.connector.model.main.ServerType;

public class GetServerType extends AbstractGet<ServerType> {

    public GetServerType(long id) {
        super(ServerType.class, id);
    }

    @Override
    public String getEndPoint() {
        return String.format("server_types/%d", id);
    }

    @Override
    public String getJsonKey() {
        return "server_type";
    }
}
