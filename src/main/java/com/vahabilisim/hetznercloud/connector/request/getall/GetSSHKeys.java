package com.vahabilisim.hetznercloud.connector.request.getall;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.vahabilisim.hetznercloud.connector.model.main.SSHKey;
import com.vahabilisim.hetznercloud.connector.response.ResponsePaginatedList;
import java.util.List;

public class GetSSHKeys extends AbstractGetAll<GetSSHKeys.ResponseSSHKeys> {

    public GetSSHKeys() {
        super(ResponseSSHKeys.class);
    }

    @Override
    public String getEndPoint() {
        return "ssh_keys";
    }

    public static class ResponseSSHKeys extends ResponsePaginatedList<SSHKey> {

        @JsonProperty("ssh_keys")
        public void setSSHKeys(List<SSHKey> list) {
            setList(list);
        }
    }
}
