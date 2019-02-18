package com.vahabilisim.hetznercloud.connector.request.get;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vahabilisim.hetznercloud.connector.request.HttpMethod;
import com.vahabilisim.hetznercloud.connector.request.AbstractRequest;

public abstract class AbstractGet<T> extends AbstractRequest<T> {

    @JsonIgnore
    protected final long id;

    public AbstractGet(Class<T> responseClass, long id) {
        super(responseClass);
        this.id = id;
    }

    @Override
    public final HttpMethod getHttpMethod() {
        return HttpMethod.GET;
    }

    @Override
    public final Object getPostData() {
        return null;
    }
}
