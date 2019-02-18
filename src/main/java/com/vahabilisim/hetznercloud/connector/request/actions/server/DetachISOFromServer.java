package com.vahabilisim.hetznercloud.connector.request.actions.server;

import com.vahabilisim.hetznercloud.connector.model.main.Server;
import com.vahabilisim.hetznercloud.connector.request.actions.AbstractAction;
import com.vahabilisim.hetznercloud.connector.response.ResponseRootPassword;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class DetachISOFromServer extends AbstractAction<ResponseRootPassword> {

    @Builder
    public DetachISOFromServer(Server server) {
        super(ResponseRootPassword.class, server.getId());
    }

    @Override
    public String getEndPoint() {
        return String.format("servers/%d/actions/detach_iso", id);
    }

    @Override
    public String getJsonKey() {
        return "action";
    }
}
