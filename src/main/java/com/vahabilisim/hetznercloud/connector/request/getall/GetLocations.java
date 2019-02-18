package com.vahabilisim.hetznercloud.connector.request.getall;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.vahabilisim.hetznercloud.connector.model.main.Location;
import com.vahabilisim.hetznercloud.connector.response.ResponsePaginatedList;
import java.util.List;

public class GetLocations extends AbstractGetAll<GetLocations.ResponseLocations> {

    public GetLocations() {
        super(ResponseLocations.class);
    }

    @Override
    public String getEndPoint() {
        return "locations";
    }

    public static class ResponseLocations extends ResponsePaginatedList<Location> {

        @JsonProperty("locations")
        public void setLocations(List<Location> list) {
            setList(list);
        }
    }
}
