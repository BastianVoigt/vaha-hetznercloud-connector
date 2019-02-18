package com.vahabilisim.hetznercloud.connector.request.actions.server;

import com.vahabilisim.hetznercloud.connector.model.main.Action;
import com.vahabilisim.hetznercloud.connector.model.main.Server;
import com.vahabilisim.hetznercloud.connector.request.actions.AbstractAction;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class DisableRescueMode extends AbstractAction<Action> {

    @Builder
    public DisableRescueMode(Server server) {
        super(Action.class, server.getId());
    }

    @Override
    public String getEndPoint() {
        return String.format("servers/%d/actions/disable_rescue", id);
    }

    @Override
    public String getJsonKey() {
        return "action";
    }
}
