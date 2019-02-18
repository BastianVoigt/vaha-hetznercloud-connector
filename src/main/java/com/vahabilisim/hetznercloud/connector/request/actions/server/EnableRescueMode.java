package com.vahabilisim.hetznercloud.connector.request.actions.server;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.vahabilisim.hetznercloud.connector.model.common.RescueSystem;
import com.vahabilisim.hetznercloud.connector.model.main.SSHKey;
import com.vahabilisim.hetznercloud.connector.model.main.Server;
import com.vahabilisim.hetznercloud.connector.request.actions.AbstractAction;
import com.vahabilisim.hetznercloud.connector.response.ResponseRootPassword;
import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class EnableRescueMode extends AbstractAction<ResponseRootPassword> {

    private RescueSystem type;
    @JsonProperty("ssh_keys")
    private List<SSHKey> sshKeys;

    @Builder
    public EnableRescueMode(Server server, RescueSystem type, List<SSHKey> sshKeys) {
        super(ResponseRootPassword.class, server.getId());
        this.type = type;
        this.sshKeys = sshKeys;
    }

    @Override
    public String getEndPoint() {
        return String.format("servers/%d/actions/enable_rescue", id);
    }

    @Override
    public String getJsonKey() {
        return null;
    }
}
