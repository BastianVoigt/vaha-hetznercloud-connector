package com.vahabilisim.hetznercloud.connector.request.create;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.vahabilisim.hetznercloud.connector.model.main.Location;
import com.vahabilisim.hetznercloud.connector.model.main.Server;
import com.vahabilisim.hetznercloud.connector.model.main.Volume;
import com.vahabilisim.hetznercloud.connector.response.ResponseCreateVolume;
import com.vahabilisim.hetznercloud.connector.util.IDConverter;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class CreateVolume extends AbstractCreate<ResponseCreateVolume> {

    private long size;
    private String name;
    private boolean automount;
    private Volume.Format format;
    @JsonSerialize(converter = IDConverter.class)
    private Location location;
    @JsonSerialize(converter = IDConverter.class)
    private Server server;

    @Builder
    public CreateVolume(long size, String name, boolean automount, Volume.Format format, Location location, Server server) {
        super(ResponseCreateVolume.class);
        this.size = size;
        this.name = name;
        this.automount = automount;
        this.format = format;
        this.location = location;
        this.server = server;
    }

    @Override
    public String getEndPoint() {
        return "volumes";
    }

    @Override
    public String getJsonKey() {
        return null;
    }
}
