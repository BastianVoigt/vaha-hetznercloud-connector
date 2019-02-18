package com.vahabilisim.hetznercloud.connector.request.create;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vahabilisim.hetznercloud.connector.model.main.Image;
import com.vahabilisim.hetznercloud.connector.model.main.Server;
import com.vahabilisim.hetznercloud.connector.response.ResponseCreateImage;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class CreateImage extends AbstractCreate<ResponseCreateImage> {

    private String description;
    private Image.Type type;
    @JsonIgnore
    private Server server;

    @Builder
    public CreateImage(String description, Image.Type type, Server server) {
        super(ResponseCreateImage.class);
        this.description = description;
        this.type = type;
        this.server = server;
    }

    @Override
    public String getEndPoint() {
        return String.format("servers/%d/actions/create_image", server.getId());
    }

    @Override
    public String getJsonKey() {
        return null;
    }
}
