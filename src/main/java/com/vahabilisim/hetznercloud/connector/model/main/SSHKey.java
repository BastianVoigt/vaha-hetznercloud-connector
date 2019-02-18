package com.vahabilisim.hetznercloud.connector.model.main;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.vahabilisim.hetznercloud.connector.model.IDInterface;
import lombok.Data;
import java.util.Map;

@Data
public class SSHKey implements IDInterface {

    private long id;
    private String name;
    private String fingerprint;
    @JsonProperty("public_key")
    private String publicKey;
    private Map<String, String> labels;
}
