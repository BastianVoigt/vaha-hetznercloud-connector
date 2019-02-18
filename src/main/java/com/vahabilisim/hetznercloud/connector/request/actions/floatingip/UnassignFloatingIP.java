package com.vahabilisim.hetznercloud.connector.request.actions.floatingip;

import com.vahabilisim.hetznercloud.connector.model.main.Action;
import com.vahabilisim.hetznercloud.connector.model.main.FloatingIP;
import com.vahabilisim.hetznercloud.connector.request.actions.AbstractAction;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class UnassignFloatingIP extends AbstractAction<Action> {

    @Builder
    public UnassignFloatingIP(FloatingIP floatingIP) {
        super(Action.class, floatingIP.getId());
    }

    @Override
    public String getEndPoint() {
        return String.format("floating_ips/%d/actions/unassign", id);
    }

    @Override
    public String getJsonKey() {
        return "action";
    }
}
