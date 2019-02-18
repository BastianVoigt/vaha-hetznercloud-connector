package com.vahabilisim.hetznercloud.connector.request.actions;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vahabilisim.hetznercloud.connector.request.HttpMethod;
import com.vahabilisim.hetznercloud.connector.request.AbstractRequest;

public abstract class AbstractAction<T> extends AbstractRequest<T> {

    @JsonIgnore
    protected final long id;

    public AbstractAction(Class<T> responseClass, long id) {
        super(responseClass);
        this.id = id;
    }

    @Override
    public final HttpMethod getHttpMethod() {
        return HttpMethod.POST;
    }

    @Override
    public final Object getPostData() {
        return this;
    }
}
