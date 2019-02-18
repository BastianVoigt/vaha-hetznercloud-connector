package com.vahabilisim.hetznercloud.connector.model.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PriceServerType {

    private String location;
    @JsonProperty("price_hourly")
    private NetAndGross priceHourly;
    @JsonProperty("price_monthly")
    private NetAndGross priceMonthly;
}
