package com.vahabilisim.hetznercloud.connector.request.delete;

import com.vahabilisim.hetznercloud.connector.model.main.Volume;

public class DeleteVolume extends AbstractDelete<Void> {

    public DeleteVolume(Volume volume) {
        super(Void.class, volume.getId());
    }

    @Override
    public String getEndPoint() {
        return String.format("volumes/%d", id);
    }

    @Override
    public String getJsonKey() {
        return null;
    }
}
