package com.vahabilisim.hetznercloud.connector.request.create;

import com.vahabilisim.hetznercloud.connector.request.HttpMethod;
import com.vahabilisim.hetznercloud.connector.request.AbstractRequest;

public abstract class AbstractCreate<T> extends AbstractRequest<T> {

    public AbstractCreate(Class<T> responseClass) {
        super(responseClass);
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
