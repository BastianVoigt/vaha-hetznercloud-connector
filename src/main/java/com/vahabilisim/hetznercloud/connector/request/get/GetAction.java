package com.vahabilisim.hetznercloud.connector.request.get;

import com.vahabilisim.hetznercloud.connector.model.main.Action;

public class GetAction extends AbstractGet<Action> {

    public GetAction(long id) {
        super(Action.class, id);
    }

    @Override
    public String getEndPoint() {
        return String.format("actions/%d", id);
    }

    @Override
    public String getJsonKey() {
        return "action";
    }
}
