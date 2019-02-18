package com.vahabilisim.hetznercloud.connector.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.vahabilisim.hetznercloud.connector.model.main.Action;
import com.vahabilisim.hetznercloud.connector.model.main.FloatingIP;
import lombok.Data;

@Data
public class ResponseCreateFloatingIP {

    @JsonProperty("floating_ip")
    private FloatingIP floatingIP;
    private Action action;
}
