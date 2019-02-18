package com.vahabilisim.hetznercloud.connector.request.actions.image;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.vahabilisim.hetznercloud.connector.model.common.Protection;
import com.vahabilisim.hetznercloud.connector.model.main.Action;
import com.vahabilisim.hetznercloud.connector.model.main.Image;
import com.vahabilisim.hetznercloud.connector.request.actions.AbstractAction;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ChangeImageProtection extends AbstractAction<Action> {

    @JsonUnwrapped
    @JsonIgnoreProperties("rebuild")
    private Protection protection;

    @Builder
    public ChangeImageProtection(Image image, Protection protection) {
        super(Action.class, image.getId());
        this.protection = protection;
    }

    @Override
    public String getEndPoint() {
        return String.format("images/%d/actions/change_protection", id);
    }

    @Override
    public String getJsonKey() {
        return "action";
    }
}
