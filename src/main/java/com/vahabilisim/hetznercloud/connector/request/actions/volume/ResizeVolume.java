package com.vahabilisim.hetznercloud.connector.request.actions.volume;

import com.vahabilisim.hetznercloud.connector.model.main.Action;
import com.vahabilisim.hetznercloud.connector.model.main.Volume;
import com.vahabilisim.hetznercloud.connector.request.actions.AbstractAction;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ResizeVolume extends AbstractAction<Action> {

    private long size;

    @Builder
    public ResizeVolume(Volume volume, long size) {
        super(Action.class, volume.getId());
        this.size = size;
    }

    @Override
    public String getEndPoint() {
        return String.format("volumes/%d/actions/resize", id);
    }

    @Override
    public String getJsonKey() {
        return "action";
    }
}
