package com.vahabilisim.hetznercloud.connector.request.actions.floatingip;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.vahabilisim.hetznercloud.connector.model.common.Protection;
import com.vahabilisim.hetznercloud.connector.model.main.Action;
import com.vahabilisim.hetznercloud.connector.model.main.FloatingIP;
import com.vahabilisim.hetznercloud.connector.request.actions.AbstractAction;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ChangeFloatingIPProtection extends AbstractAction<Action> {

    @JsonUnwrapped
    @JsonIgnoreProperties("rebuild")
    private Protection protection;

    @Builder
    public ChangeFloatingIPProtection(FloatingIP floatingIP, Protection protection) {
        super(Action.class, floatingIP.getId());
        this.protection = protection;
    }

    @Override
    public String getEndPoint() {
        return String.format("floating_ips/%d/actions/change_protection", id);
    }

    @Override
    public String getJsonKey() {
        return "action";
    }
}
