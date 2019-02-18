package com.vahabilisim.hetznercloud.connector.request.getall;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.vahabilisim.hetznercloud.connector.model.main.Datacenter;
import com.vahabilisim.hetznercloud.connector.response.ResponsePaginatedList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

public class GetDatacenters extends AbstractGetAll<GetDatacenters.ResponseDatacenters> {

    public GetDatacenters() {
        super(ResponseDatacenters.class);
    }

    @Override
    public String getEndPoint() {
        return "datacenters";
    }

    public static class ResponseDatacenters extends ResponsePaginatedList<Datacenter> {

        @Getter
        @Setter
        private long recommendation;

        @JsonProperty("datacenters")
        public void setDatacenters(List<Datacenter> list) {
            setList(list);
        }
    }
}
