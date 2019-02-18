package com.vahabilisim.hetznercloud.connector.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.vahabilisim.hetznercloud.connector.model.main.Action;
import lombok.Data;

@Data
public class ResponseRootPassword {

    @JsonProperty("root_password")
    private String rootPassword;
    private Action action;

}
