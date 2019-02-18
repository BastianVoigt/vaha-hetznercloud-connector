package com.vahabilisim.hetznercloud.connector.request.actions.volume;

import com.vahabilisim.hetznercloud.connector.model.main.Action;
import com.vahabilisim.hetznercloud.connector.model.main.Volume;
import com.vahabilisim.hetznercloud.connector.request.actions.AbstractAction;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class DetachVolume extends AbstractAction<Action> {

    @Builder
    public DetachVolume(Volume volume) {
        super(Action.class, volume.getId());
    }

    @Override
    public String getEndPoint() {
        return String.format("volumes/%d/actions/detach", id);
    }

    @Override
    public String getJsonKey() {
        return "action";
    }
}
