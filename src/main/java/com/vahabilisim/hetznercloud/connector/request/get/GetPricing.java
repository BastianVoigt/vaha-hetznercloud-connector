package com.vahabilisim.hetznercloud.connector.request.get;

import com.vahabilisim.hetznercloud.connector.model.main.Pricing;

public class GetPricing extends AbstractGet<Pricing> {

    public GetPricing() {
        super(Pricing.class, 0L);
    }

    @Override
    public String getEndPoint() {
        return "pricing";
    }

    @Override
    public String getJsonKey() {
        return "pricing";
    }
}
