 
package com.vahabilisim.hetznercloud.connector.request.update;

import com.vahabilisim.hetznercloud.connector.model.main.Server;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

 

@Data
@EqualsAndHashCode(callSuper = false)
public class UpdateServer extends AbstractUpdate<Server>{
    
    private String name;

    @Builder
    public UpdateServer(Server server, String name) {
        super(Server.class, server.getId());
        this.name = name;
    }

    @Override
    public String getEndPoint() {
        return String.format("servers/%d", id);
    }

    @Override
    public String getJsonKey() {
        return "server";
    }    
}
