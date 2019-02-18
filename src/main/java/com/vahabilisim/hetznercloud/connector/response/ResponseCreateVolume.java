package com.vahabilisim.hetznercloud.connector.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.vahabilisim.hetznercloud.connector.model.main.Action;
import com.vahabilisim.hetznercloud.connector.model.main.Volume;
import java.util.List;
import lombok.Data;

@Data
public class ResponseCreateVolume {

    private Volume volume;
    private Action action;
    @JsonProperty("next_actions")
    private List<Action> nextActions;
}
