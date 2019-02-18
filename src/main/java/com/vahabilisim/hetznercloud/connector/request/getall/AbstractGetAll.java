package com.vahabilisim.hetznercloud.connector.request.getall;

import com.vahabilisim.hetznercloud.connector.request.HttpMethod;
import com.vahabilisim.hetznercloud.connector.request.AbstractRequest;
import com.vahabilisim.hetznercloud.connector.response.ResponsePaginatedList;

public abstract class AbstractGetAll<T extends ResponsePaginatedList> extends AbstractRequest<T> {

    public AbstractGetAll(Class<T> responseClass) {
        super(responseClass);
    }

    @Override
    public final HttpMethod getHttpMethod() {
        return HttpMethod.GET;
    }

    @Override
    public final String getJsonKey() {
        return null;
    }

    @Override
    public final Object getPostData() {
        return null;
    }
}
