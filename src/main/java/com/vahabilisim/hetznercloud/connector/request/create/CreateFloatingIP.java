package com.vahabilisim.hetznercloud.connector.request.create;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.vahabilisim.hetznercloud.connector.model.main.FloatingIP;
import com.vahabilisim.hetznercloud.connector.model.main.Location;
import com.vahabilisim.hetznercloud.connector.model.main.Server;
import com.vahabilisim.hetznercloud.connector.response.ResponseCreateFloatingIP;
import com.vahabilisim.hetznercloud.connector.util.IDConverter;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class CreateFloatingIP extends AbstractCreate<ResponseCreateFloatingIP> {

    private FloatingIP.Type type;
    @JsonSerialize(converter = IDConverter.class)
    private Server server;
    @JsonSerialize(converter = IDConverter.class)
    @JsonProperty("home_location")
    private Location homeLocation;
    private String description;

    @Builder
    public CreateFloatingIP(FloatingIP.Type type, Server server, Location homeLocation, String description) {
        super(ResponseCreateFloatingIP.class);
        this.type = type;
        this.server = server;
        this.homeLocation = homeLocation;
        this.description = description;
    }

    @Override
    public String getEndPoint() {
        return "floating_ips";
    }

    @Override
    public String getJsonKey() {
        return null;
    }
}
