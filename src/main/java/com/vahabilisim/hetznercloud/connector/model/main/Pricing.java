package com.vahabilisim.hetznercloud.connector.model.main;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.vahabilisim.hetznercloud.connector.model.common.NetAndGross;
import com.vahabilisim.hetznercloud.connector.model.common.PriceServerType;
import lombok.Data;
import java.util.List;

@Data
public class Pricing {

    private String currency;
    @JsonProperty("vat_rate")
    private double vatRate;
    private PricePerGBMonth image;
    @JsonProperty("floating_ip")
    private PriceMonthly floatingIP;
    private PricePerTB traffic;
    @JsonProperty("server_backup")
    private ServerBackup serverBackup;
    private PricePerGBMonth volume;
    @JsonProperty("server_types")
    private List<ServerType> serverTypes;

    @Data
    public class PricePerGBMonth {

        @JsonProperty("price_per_gb_month")
        private NetAndGross pricePerGBMonth;
    }

    @Data
    public class PriceMonthly {

        @JsonProperty("price_monthly")
        private NetAndGross priceMonthly;
    }

    @Data
    public class PricePerTB {

        @JsonProperty("price_per_tb")
        private NetAndGross pricePerTB;
    }

    @Data
    public static class ServerBackup {

        private double percentage;
    }

    @Data
    public static class ServerType {

        private long id;
        private String name;
        private List<PriceServerType> prices;
    }
}
