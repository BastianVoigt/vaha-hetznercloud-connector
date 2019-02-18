package com.vahabilisim.hetznercloud.connector.request.get;

import com.vahabilisim.hetznercloud.connector.model.main.Location;

public class GetLocation extends AbstractGet<Location> {

    public GetLocation(long id) {
        super(Location.class, id);
    }

    @Override
    public String getEndPoint() {
        return String.format("locations/%d", id);
    }

    @Override
    public String getJsonKey() {
        return "location";
    }
}
