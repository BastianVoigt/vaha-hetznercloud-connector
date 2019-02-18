package com.vahabilisim.hetznercloud.connector.request.actions.server;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.vahabilisim.hetznercloud.connector.model.common.Protection;
import com.vahabilisim.hetznercloud.connector.model.main.Action;
import com.vahabilisim.hetznercloud.connector.model.main.Server;
import com.vahabilisim.hetznercloud.connector.request.actions.AbstractAction;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ChangeServerProtection extends AbstractAction<Action> {

    @JsonUnwrapped
    private Protection protection;

    @Builder
    public ChangeServerProtection(Server server, Protection protection) {
        super(Action.class, server.getId());
        this.protection = protection;
    }

    @Override
    public String getEndPoint() {
        return String.format("servers/%d/actions/change_protection", id);
    }

    @Override
    public String getJsonKey() {
        return "action";
    }
}
