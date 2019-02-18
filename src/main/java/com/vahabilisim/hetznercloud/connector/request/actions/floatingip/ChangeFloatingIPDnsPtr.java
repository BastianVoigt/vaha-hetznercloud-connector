package com.vahabilisim.hetznercloud.connector.request.actions.floatingip;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.vahabilisim.hetznercloud.connector.model.common.DnsPTR;
import com.vahabilisim.hetznercloud.connector.model.main.Action;
import com.vahabilisim.hetznercloud.connector.model.main.FloatingIP;
import com.vahabilisim.hetznercloud.connector.request.actions.AbstractAction;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ChangeFloatingIPDnsPtr extends AbstractAction<Action> {

    @JsonUnwrapped
    private DnsPTR dnsPTR;

    @Builder
    public ChangeFloatingIPDnsPtr(FloatingIP floatingIP, DnsPTR dnsPTR) {
        super(Action.class, floatingIP.getId());
        this.dnsPTR = dnsPTR;
    }

    @Override
    public String getEndPoint() {
        return String.format("floating_ips/%d/actions/change_dns_ptr", id);
    }

    @Override
    public String getJsonKey() {
        return "action";
    }
}
