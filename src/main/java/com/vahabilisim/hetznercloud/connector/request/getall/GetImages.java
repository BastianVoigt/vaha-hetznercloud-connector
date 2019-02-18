package com.vahabilisim.hetznercloud.connector.request.getall;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.vahabilisim.hetznercloud.connector.model.main.Image;
import com.vahabilisim.hetznercloud.connector.response.ResponsePaginatedList;
import java.util.List;

public class GetImages extends AbstractGetAll<GetImages.ResponseImages> {

    public GetImages() {
        super(ResponseImages.class);
    }

    @Override
    public String getEndPoint() {
        return "images";
    }

    public static class ResponseImages extends ResponsePaginatedList<Image> {

        @JsonProperty("images")
        public void setImages(List<Image> list) {
            setList(list);
        }
    }
}
