package com.vahabilisim.hetznercloud.connector.request.get;

import com.vahabilisim.hetznercloud.connector.model.main.Datacenter;

public class GetDatacenter extends AbstractGet<Datacenter> {

    public GetDatacenter(long id) {
        super(Datacenter.class, id);
    }

    @Override
    public String getEndPoint() {
        return String.format("datacenters/%d", id);
    }

    @Override
    public String getJsonKey() {
        return "datacenter";
    }
}
