package com.vahabilisim.hetznercloud.connector.request.get;

import com.vahabilisim.hetznercloud.connector.model.main.FloatingIP;

public class GetFloatingIP extends AbstractGet<FloatingIP> {

    public GetFloatingIP(long id) {
        super(FloatingIP.class, id);
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
