package com.vahabilisim.hetznercloud.connector.request.delete;

import com.vahabilisim.hetznercloud.connector.model.main.SSHKey;

public class DeleteSSHKey extends AbstractDelete<Void> {

    public DeleteSSHKey(SSHKey sshKey) {
        super(Void.class, sshKey.getId());
    }

    @Override
    public String getEndPoint() {
        return String.format("ssh_keys/%d", id);
    }

    @Override
    public String getJsonKey() {
        return null;
    }
}
