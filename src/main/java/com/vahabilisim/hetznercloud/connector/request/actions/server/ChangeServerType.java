package com.vahabilisim.hetznercloud.connector.request.actions.server;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.vahabilisim.hetznercloud.connector.model.main.Action;
import com.vahabilisim.hetznercloud.connector.model.main.Server;
import com.vahabilisim.hetznercloud.connector.model.main.ServerType;
import com.vahabilisim.hetznercloud.connector.request.actions.AbstractAction;
import com.vahabilisim.hetznercloud.connector.util.IDConverter;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ChangeServerType extends AbstractAction<Action> {

    @JsonProperty("upgrade_disk")
    private boolean upgradeDisk;
    @JsonProperty("server_type")
    @JsonSerialize(converter = IDConverter.class)
    private ServerType serverType;

    @Builder
    public ChangeServerType(Server server, boolean upgradeDisk, ServerType serverType) {
        super(Action.class, server.getId());
        this.upgradeDisk = upgradeDisk;
        this.serverType = serverType;
    }

    @Override
    public String getEndPoint() {
        return String.format("servers/%d/actions/change_type", id);
    }

    @Override
    public String getJsonKey() {
        return "action";
    }
}
