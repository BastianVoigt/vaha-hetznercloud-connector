package com.vahabilisim.hetznercloud.connector.request.delete;

import com.vahabilisim.hetznercloud.connector.model.main.FloatingIP;

public class DeleteFloatingIP extends AbstractDelete<Void> {

    public DeleteFloatingIP(FloatingIP floatingIP) {
        super(Void.class, floatingIP.getId());
    }

    @Override
    public String getEndPoint() {
        return String.format("floating_ips/%d", id);
    }

    @Override
    public String getJsonKey() {
        return null;
    }
}
