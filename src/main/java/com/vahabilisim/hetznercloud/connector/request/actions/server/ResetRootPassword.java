package com.vahabilisim.hetznercloud.connector.request.actions.server;

import com.vahabilisim.hetznercloud.connector.model.main.Server;
import com.vahabilisim.hetznercloud.connector.request.actions.AbstractAction;
import com.vahabilisim.hetznercloud.connector.response.ResponseRootPassword;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ResetRootPassword extends AbstractAction<ResponseRootPassword> {

    @Builder
    public ResetRootPassword(Server server) {
        super(ResponseRootPassword.class, server.getId());
    }

    @Override
    public String getEndPoint() {
        return String.format("servers/%d/actions/reset_password", id);
    }

    @Override
    public String getJsonKey() {
        return null;
    }
}
