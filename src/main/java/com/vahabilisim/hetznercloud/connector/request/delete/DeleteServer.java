package com.vahabilisim.hetznercloud.connector.request.delete;

import com.vahabilisim.hetznercloud.connector.model.main.Action;
import com.vahabilisim.hetznercloud.connector.model.main.Server;

public class DeleteServer extends AbstractDelete<Action> {

    public DeleteServer(Server server) {
        super(Action.class, server.getId());
    }

    @Override
    public String getEndPoint() {
        return String.format("servers/%d", id);
    }

    @Override
    public String getJsonKey() {
        return "action";
    }
}
