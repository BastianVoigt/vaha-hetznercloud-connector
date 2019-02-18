package com.vahabilisim.hetznercloud.connector.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.vahabilisim.hetznercloud.connector.model.main.Action;
import com.vahabilisim.hetznercloud.connector.model.main.Server;
import java.util.List;
import lombok.Data;

@Data
public class ResponseCreateServer {

    private Server server;
    private Action action;
    @JsonProperty("next_actions")
    private List<Action> nextActions;
    @JsonProperty("root_password")
    private String rootPassword;
}
