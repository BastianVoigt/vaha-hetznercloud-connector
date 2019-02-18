package com.vahabilisim.hetznercloud.connector.request.get;

import com.vahabilisim.hetznercloud.connector.model.main.ISO;

public class GetISO extends AbstractGet<ISO> {

    public GetISO(long id) {
        super(ISO.class, id);
    }

    @Override
    public String getEndPoint() {
        return String.format("isos/%d", id);
    }

    @Override
    public String getJsonKey() {
        return "iso";
    }
}
