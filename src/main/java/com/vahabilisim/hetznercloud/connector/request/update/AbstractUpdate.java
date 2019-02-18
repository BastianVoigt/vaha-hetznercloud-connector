package com.vahabilisim.hetznercloud.connector.request.update;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vahabilisim.hetznercloud.connector.request.AbstractRequest;
import com.vahabilisim.hetznercloud.connector.request.HttpMethod;

public abstract class AbstractUpdate<T> extends AbstractRequest<T> {

    @JsonIgnore
    protected final long id;

    public AbstractUpdate(Class<T> responseClass, long id) {
        super(responseClass);
        this.id = id;
    }

    @Override
    public final HttpMethod getHttpMethod() {
        return HttpMethod.PUT;
    }

    @Override
    public final Object getPostData() {
        return this;
    }
}
