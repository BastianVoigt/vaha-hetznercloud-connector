package com.vahabilisim.hetznercloud.connector.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.vahabilisim.hetznercloud.connector.model.main.Action;
import lombok.Data;

@Data
public class ResponseServerConsole {

    @JsonProperty("wss_url")
    private String wssUrl;
    private String password;
    private Action action;

}
