package com.vahabilisim.hetznercloud.connector.request.create;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.vahabilisim.hetznercloud.connector.model.main.SSHKey;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class CreateSSHKey extends AbstractCreate<SSHKey> {

    private String name;
    @JsonProperty("public_key")
    private String publicKey;

    @Builder
    public CreateSSHKey(String name, String publicKey) {
        super(SSHKey.class);
        this.name = name;
        this.publicKey = publicKey;
    }

    @Override
    public String getEndPoint() {
        return "ssh_keys";
    }

    @Override
    public String getJsonKey() {
        return "ssh_key";
    }
}
