package com.vahabilisim.hetznercloud.connector.request.update;

import com.vahabilisim.hetznercloud.connector.model.main.FloatingIP;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class UpdateFloatingIP extends AbstractUpdate<FloatingIP> {

    private String description;

    @Builder
    public UpdateFloatingIP(FloatingIP floatingIP, String description) {
        super(FloatingIP.class, floatingIP.getId());
        this.description = description;
    }

    @Override
    public String getEndPoint() {
        return String.format("floating_ips/%d", id);
    }

    @Override
    public String getJsonKey() {
        return "floating_ip";
    }
}
