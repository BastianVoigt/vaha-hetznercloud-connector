package com.vahabilisim.hetznercloud.connector.request.delete;

import com.vahabilisim.hetznercloud.connector.model.main.Image;

public class DeleteImage extends AbstractDelete<Void> {

    public DeleteImage(Image image) {
        super(Void.class, image.getId());
    }

    @Override
    public String getEndPoint() {
        return String.format("images/%d", id);
    }

    @Override
    public String getJsonKey() {
        return null;
    }
}
