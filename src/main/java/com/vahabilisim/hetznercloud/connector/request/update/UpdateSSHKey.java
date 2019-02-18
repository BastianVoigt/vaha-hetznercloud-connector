package com.vahabilisim.hetznercloud.connector.request.update;

import com.vahabilisim.hetznercloud.connector.model.main.SSHKey;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class UpdateSSHKey extends AbstractUpdate<SSHKey> {

    private String name;

    @Builder
    public UpdateSSHKey(SSHKey sshKey, String name) {
        super(SSHKey.class, sshKey.getId());
        this.name = name;
    }

    @Override
    public String getEndPoint() {
        return String.format("ssh_keys/%d", id);
    }

    @Override
    public String getJsonKey() {
        return "ssh_key";
    }
}
