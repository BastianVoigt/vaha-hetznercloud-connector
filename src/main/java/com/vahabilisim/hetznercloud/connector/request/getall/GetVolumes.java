package com.vahabilisim.hetznercloud.connector.request.getall;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.vahabilisim.hetznercloud.connector.model.main.Volume;
import com.vahabilisim.hetznercloud.connector.response.ResponsePaginatedList;
import java.util.List;

public class GetVolumes extends AbstractGetAll<GetVolumes.ResponseVolumes> {

    public GetVolumes() {
        super(ResponseVolumes.class);
    }

    @Override
    public String getEndPoint() {
        return "volumes";
    }

    public static class ResponseVolumes extends ResponsePaginatedList<Volume> {

        @JsonProperty("volumes")
        public void setVolumes(List<Volume> list) {
            setList(list);
        }
    }
}
