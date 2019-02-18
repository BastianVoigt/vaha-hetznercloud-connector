package com.vahabilisim.hetznercloud.connector.request.getall;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.vahabilisim.hetznercloud.connector.model.main.ISO;
import com.vahabilisim.hetznercloud.connector.response.ResponsePaginatedList;
import java.util.List;

public class GetISOs extends AbstractGetAll<GetISOs.ResponseISOs> {

    public GetISOs() {
        super(ResponseISOs.class);
    }

    @Override
    public String getEndPoint() {
        return "isos";
    }

    public static class ResponseISOs extends ResponsePaginatedList<ISO> {

        @JsonProperty("isos")
        public void setISOs(List<ISO> list) {
            setList(list);
        }
    }
}
