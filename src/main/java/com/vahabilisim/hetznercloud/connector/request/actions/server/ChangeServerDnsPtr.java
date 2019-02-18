package com.vahabilisim.hetznercloud.connector.request.actions.server;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.vahabilisim.hetznercloud.connector.model.common.DnsPTR;
import com.vahabilisim.hetznercloud.connector.model.main.Action;
import com.vahabilisim.hetznercloud.connector.model.main.Server;
import com.vahabilisim.hetznercloud.connector.request.actions.AbstractAction;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ChangeServerDnsPtr extends AbstractAction<Action> {

    @JsonUnwrapped
    private DnsPTR dnsPTR;

    @Builder
    public ChangeServerDnsPtr(Server server, DnsPTR dnsPTR) {
        super(Action.class, server.getId());
        this.dnsPTR = dnsPTR;
    }

    @Override
    public String getEndPoint() {
        return String.format("servers/%d/actions/change_dns_ptr", id);
    }

    @Override
    public String getJsonKey() {
        return "action";
    }
}
