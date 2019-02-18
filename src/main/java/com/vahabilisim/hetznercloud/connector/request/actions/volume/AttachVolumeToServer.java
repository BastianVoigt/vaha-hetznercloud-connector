package com.vahabilisim.hetznercloud.connector.request.actions.volume;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.vahabilisim.hetznercloud.connector.model.main.Action;
import com.vahabilisim.hetznercloud.connector.model.main.Server;
import com.vahabilisim.hetznercloud.connector.model.main.Volume;
import com.vahabilisim.hetznercloud.connector.request.actions.AbstractAction;
import com.vahabilisim.hetznercloud.connector.util.IDConverter;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class AttachVolumeToServer extends AbstractAction<Action> {

    @JsonSerialize(converter = IDConverter.class)
    private Server server;
    private boolean automount;

    @Builder
    public AttachVolumeToServer(Volume volume, Server server, boolean automount) {
        super(Action.class, volume.getId());
        this.server = server;
        this.automount = automount;
    }

    @Override
    public String getEndPoint() {
        return String.format("volumes/%d/actions/attach", id);
    }

    @Override
    public String getJsonKey() {
        return "action";
    }
}
