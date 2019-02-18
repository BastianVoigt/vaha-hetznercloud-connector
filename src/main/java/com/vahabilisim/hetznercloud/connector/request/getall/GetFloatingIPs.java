package com.vahabilisim.hetznercloud.connector.request.getall;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.vahabilisim.hetznercloud.connector.model.main.FloatingIP;
import com.vahabilisim.hetznercloud.connector.response.ResponsePaginatedList;
import java.util.List;

public class GetFloatingIPs extends AbstractGetAll<GetFloatingIPs.ResponseFloatingIPs> {

    public GetFloatingIPs() {
        super(ResponseFloatingIPs.class);
    }

    @Override
    public String getEndPoint() {
        return "floating_ips";
    }

    public static class ResponseFloatingIPs extends ResponsePaginatedList<FloatingIP> {

        @JsonProperty("floating_ips")
        public void setFloatingIPs(List<FloatingIP> list) {
            setList(list);
        }
    }
}
