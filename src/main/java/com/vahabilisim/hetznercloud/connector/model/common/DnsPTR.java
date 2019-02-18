package com.vahabilisim.hetznercloud.connector.model.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class DnsPTR {

    private String ip;
    @JsonProperty("dns_ptr")
    private String dnsPTR;
}
