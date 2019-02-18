package com.vahabilisim.hetznercloud.connector.request.create;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.vahabilisim.hetznercloud.connector.model.main.Image;
import com.vahabilisim.hetznercloud.connector.model.main.Location;
import com.vahabilisim.hetznercloud.connector.model.main.SSHKey;
import com.vahabilisim.hetznercloud.connector.model.main.ServerType;
import com.vahabilisim.hetznercloud.connector.model.main.Volume;
import com.vahabilisim.hetznercloud.connector.util.IDListConverter;
import com.vahabilisim.hetznercloud.connector.util.IDConverter;
import com.vahabilisim.hetznercloud.connector.response.ResponseCreateServer;
import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class CreateServer extends AbstractCreate<ResponseCreateServer> {

    private String name;
    @JsonProperty("server_type")
    @JsonSerialize(converter = IDConverter.class)
    private ServerType serverType;
    @JsonSerialize(converter = IDConverter.class)
    private Location location;
    @JsonProperty("start_after_create")
    private boolean startAfterCreate;
    @JsonSerialize(converter = IDConverter.class)
    private Image image;
    @JsonProperty("ssh_keys")
    @JsonSerialize(converter = IDListConverter.class)
    private List<SSHKey> sshKeys;
    @JsonSerialize(converter = IDListConverter.class)
    private List<Volume> volumes;
    @JsonProperty("user_data")
    private String userData;
    private boolean automount;

    @Builder
    public CreateServer(String name, ServerType serverType, Location location, boolean startAfterCreate, Image image, List<SSHKey> sshKeys, List<Volume> volumes, String userData, boolean automount) {
        super(ResponseCreateServer.class);
        this.name = name;
        this.serverType = serverType;
        this.location = location;
        this.startAfterCreate = startAfterCreate;
        this.image = image;
        this.sshKeys = sshKeys;
        this.volumes = volumes;
        this.userData = userData;
        this.automount = automount;
    }

    @Override
    public String getEndPoint() {
        return "servers";
    }

    @Override
    public String getJsonKey() {
        return null;
    }
}
