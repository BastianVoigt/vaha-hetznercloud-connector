package com.vahabilisim.hetznercloud.connector.request.delete;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vahabilisim.hetznercloud.connector.request.HttpMethod;
import com.vahabilisim.hetznercloud.connector.request.AbstractRequest;

public abstract class AbstractDelete<T> extends AbstractRequest<T> {

    @JsonIgnore
    protected final long id;

    public AbstractDelete(Class<T> responseClass, long id) {
        super(responseClass);
        this.id = id;
    }

    @Override
    public final HttpMethod getHttpMethod() {
        return HttpMethod.DELETE;
    }

    @Override
    public final Object getPostData() {
        return null;
    }
}
