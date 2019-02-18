package com.vahabilisim.hetznercloud.connector.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vahabilisim.hetznercloud.connector.model.common.Meta;
import java.util.List;
import lombok.Data;

@Data
public class ResponsePaginatedList<T> {

    @JsonIgnore
    private List<T> list;
    private Meta meta;
}
