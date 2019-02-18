package com.vahabilisim.hetznercloud.connector.response;

import com.vahabilisim.hetznercloud.connector.model.main.Action;
import com.vahabilisim.hetznercloud.connector.model.main.Image;
import lombok.Data;

@Data
public class ResponseCreateImage {

    private Image image;
    private Action action;
}
