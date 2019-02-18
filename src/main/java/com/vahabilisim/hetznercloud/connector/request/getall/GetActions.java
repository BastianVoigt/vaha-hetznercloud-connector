package com.vahabilisim.hetznercloud.connector.request.getall;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.vahabilisim.hetznercloud.connector.model.main.Action;
import com.vahabilisim.hetznercloud.connector.response.ResponsePaginatedList;
import java.util.List;

public class GetActions extends AbstractGetAll<GetActions.ResponseActions> {

    public GetActions() {
        super(ResponseActions.class);
    }

    @Override
    public String getEndPoint() {
        return "actions";
    }

    public static class ResponseActions extends ResponsePaginatedList<Action> {

        @JsonProperty("actions")
        public void setActions(List<Action> list) {
            setList(list);
        }
    }
}
