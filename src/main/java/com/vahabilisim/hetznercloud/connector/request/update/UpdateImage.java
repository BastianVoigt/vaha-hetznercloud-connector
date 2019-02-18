package com.vahabilisim.hetznercloud.connector.request.update;

import com.vahabilisim.hetznercloud.connector.model.main.Image;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class UpdateImage extends AbstractUpdate<Image> {

    private String description;
    private Image.Type type;

    @Builder
    public UpdateImage(Image image, String description, Image.Type type) {
        super(Image.class, image.getId());
        this.description = description;
        this.type = type;
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
