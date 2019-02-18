package com.vahabilisim.hetznercloud.connector.request.get;

import com.vahabilisim.hetznercloud.connector.model.main.Image;

public class GetImage extends AbstractGet<Image> {

    public GetImage(long id) {
        super(Image.class, id);
    }

    @Override
    public String getEndPoint() {
        return String.format("images/%d", id);
    }

    @Override
    public String getJsonKey() {
        return "image";
    }
}
