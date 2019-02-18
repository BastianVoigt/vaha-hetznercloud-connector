package com.vahabilisim.hetznercloud.connector.request.get;

import com.vahabilisim.hetznercloud.connector.model.main.Volume;

public class GetVolume extends AbstractGet<Volume> {

    public GetVolume(long id) {
        super(Volume.class, id);
    }

    @Override
    public String getEndPoint() {
        return String.format("volumes/%d", id);
    }

    @Override
    public String getJsonKey() {
        return "volume";
    }
}
