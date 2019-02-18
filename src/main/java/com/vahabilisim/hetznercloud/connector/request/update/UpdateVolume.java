package com.vahabilisim.hetznercloud.connector.request.update;

import com.vahabilisim.hetznercloud.connector.model.main.Volume;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class UpdateVolume extends AbstractUpdate<Volume> {

    private String name;

    @Builder
    public UpdateVolume(Volume volume, String name) {
        super(Volume.class, volume.getId());
        this.name = name;
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
