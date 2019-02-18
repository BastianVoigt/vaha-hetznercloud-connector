package com.vahabilisim.hetznercloud.connector.model.common;

import lombok.Data;

@Data
public class Protection {

    private boolean delete;
    private boolean rebuild; // just for server resources
}
