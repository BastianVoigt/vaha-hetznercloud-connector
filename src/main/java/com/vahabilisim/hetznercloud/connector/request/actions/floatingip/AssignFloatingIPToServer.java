package com.vahabilisim.hetznercloud.connector.request.actions.floatingip;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.vahabilisim.hetznercloud.connector.model.main.Action;
import com.vahabilisim.hetznercloud.connector.model.main.FloatingIP;
import com.vahabilisim.hetznercloud.connector.model.main.Server;
import com.vahabilisim.hetznercloud.connector.request.actions.AbstractAction;
import com.vahabilisim.hetznercloud.connector.util.IDConverter;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class AssignFloatingIPToServer extends AbstractAction<Action> {

    @JsonSerialize(converter = IDConverter.class)
    private Server server;

    @Builder
    public AssignFloatingIPToServer(FloatingIP floatingIP, Server server, boolean automount) {
        super(Action.class, floatingIP.getId());
        this.server = server;
    }

    @Override
    public String getEndPoint() {
        return String.format("floating_ips/%d/actions/assign", id);
    }

    @Override
    public String getJsonKey() {
        return "action";
    }
}
