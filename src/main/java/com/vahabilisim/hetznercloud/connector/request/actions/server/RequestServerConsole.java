package com.vahabilisim.hetznercloud.connector.request.actions.server;

import com.vahabilisim.hetznercloud.connector.model.main.Server;
import com.vahabilisim.hetznercloud.connector.request.actions.AbstractAction;
import com.vahabilisim.hetznercloud.connector.response.ResponseServerConsole;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class RequestServerConsole extends AbstractAction<ResponseServerConsole> {

    @Builder
    public RequestServerConsole(Server server) {
        super(ResponseServerConsole.class, server.getId());
    }

    @Override
    public String getEndPoint() {
        return String.format("servers/%d/actions/request_console", id);
    }

    @Override
    public String getJsonKey() {
        return null;
    }
}
