package com.vahabilisim.hetznercloud.connector.request.get;

import com.vahabilisim.hetznercloud.connector.model.main.SSHKey;

public class GetSSHKey extends AbstractGet<SSHKey> {

    public GetSSHKey(long id) {
        super(SSHKey.class, id);
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
