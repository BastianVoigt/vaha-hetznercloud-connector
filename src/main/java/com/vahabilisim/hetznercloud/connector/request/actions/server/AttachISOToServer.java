package com.vahabilisim.hetznercloud.connector.request.actions.server;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.vahabilisim.hetznercloud.connector.model.main.ISO;
import com.vahabilisim.hetznercloud.connector.model.main.Server;
import com.vahabilisim.hetznercloud.connector.request.actions.AbstractAction;
import com.vahabilisim.hetznercloud.connector.response.ResponseRootPassword;
import com.vahabilisim.hetznercloud.connector.util.IDConverter;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class AttachISOToServer extends AbstractAction<ResponseRootPassword> {

    @JsonSerialize(converter = IDConverter.class)
    private ISO iso;

    @Builder
    public AttachISOToServer(Server server, ISO iso) {
        super(ResponseRootPassword.class, server.getId());
        this.iso = iso;
    }

    @Override
    public String getEndPoint() {
        return String.format("servers/%d/actions/attach_iso", id);
    }

    @Override
    public String getJsonKey() {
        return "action";
    }
}
