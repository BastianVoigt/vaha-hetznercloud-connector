package com.vahabilisim.hetznercloud.connector.model.main;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.vahabilisim.hetznercloud.connector.model.IDInterface;
import com.vahabilisim.hetznercloud.connector.model.common.DnsPTR;
import com.vahabilisim.hetznercloud.connector.model.common.Protection;
import lombok.Data;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

@Data
public class Server implements IDInterface {

    private long id;
    private String name;
    private Status status;
    private Date created;
    @JsonProperty("public_net")
    private PublicNet publicNet;
    @JsonProperty("server_type")
    private ServerType serverType;
    private Datacenter datacenter;
    private Image image;
    private ISO iso;
    @JsonProperty("rescue_enabled")
    private boolean rescueEnabled;
    private boolean locked;
    @JsonProperty("backup_window")
    private String backupWindow;
    @JsonProperty("outgoing_traffic")
    private long outgoingTraffic;
    @JsonProperty("ingoing_traffic")
    private long ingoingTraffic;
    @JsonProperty("included_traffic")
    private long includedTraffic;
    private Protection protection;
    private Map<String, String> labels;
    private List<Long> volumes;

    @Data
    public static class PublicNet {

        private IPv4 ipv4;
        private IPv6 ipv6;
        @JsonProperty("floating_ips")
        private List<Long> floatingIPs;

        @Data
        public static class IPv4 {

            private String ip;
            private boolean blocked;
            @JsonProperty("dns_ptr")
            private String dnsPTR;
        }

        @Data
        public static class IPv6 {

            private String ip;
            private boolean blocked;
            @JsonProperty("dns_ptr")
            private List<DnsPTR> dnsPTR;
        }
    }

    public static enum Status {

        RUNNING("running"),
        INITIALIZING("initializing"),
        STARTING("starting"),
        STOPPING("stopping"),
        OFF("off"),
        DELETING("deleting"),
        MIGRATING("migrating"),
        REBUILDING("rebuilding"),
        UNKNOWN("unknown");

        public final String value;

        private Status(String value) {
            this.value = value;
        }

        @JsonValue
        public String value() {
            return value;
        }

        @JsonCreator
        public static Status creator(String value) {
            return Stream.of(values()).filter(enu -> enu.value.equals(value)).findFirst().orElse(UNKNOWN);
        }
    }
}
