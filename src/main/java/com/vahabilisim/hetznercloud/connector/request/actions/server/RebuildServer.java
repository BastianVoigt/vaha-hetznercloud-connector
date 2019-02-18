package com.vahabilisim.hetznercloud.connector.request.actions.server;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.vahabilisim.hetznercloud.connector.model.main.Image;
import com.vahabilisim.hetznercloud.connector.model.main.Server;
import com.vahabilisim.hetznercloud.connector.request.actions.AbstractAction;
import com.vahabilisim.hetznercloud.connector.response.ResponseRootPassword;
import com.vahabilisim.hetznercloud.connector.util.IDConverter;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class RebuildServer extends AbstractAction<ResponseRootPassword> {

    @JsonSerialize(converter = IDConverter.class)
    private Image image;

    @Builder
    public RebuildServer(Server server, Image image) {
        super(ResponseRootPassword.class, server.getId());
        this.image = image;
    }

    @Override
    public String getEndPoint() {
        return String.format("servers/%d/actions/rebuild", id);
    }

    @Override
    public String getJsonKey() {
        return null;
    }
}
