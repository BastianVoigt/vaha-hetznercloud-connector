package com.vahabilisim.hetznercloud.connector.model.main;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.vahabilisim.hetznercloud.connector.model.common.DnsPTR;
import com.vahabilisim.hetznercloud.connector.model.common.Protection;
import com.vahabilisim.hetznercloud.connector.model.IDInterface;
import lombok.Data;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

@Data
public class FloatingIP implements IDInterface {

    private long id;
    private String description;
    private String ip;
    private Type type;
    private long server;
    @JsonProperty("dns_ptr")
    private List<DnsPTR> dnsPTR;
    @JsonProperty("home_location")
    private Location homeLocation;
    private Protection protection;
    private boolean blocked;
    private Map<String, String> labels;

    public static enum Type {

        IPv4("ipv4"),
        IPv6("ipv6"),
        UNKNOWN("unknown");

        public final String value;

        private Type(String value) {
            this.value = value;
        }

        @JsonValue
        public String value() {
            return value;
        }

        @JsonCreator
        public static Type creator(String value) {
            return Stream.of(values()).filter(enu -> enu.value.equals(value)).findFirst().orElse(UNKNOWN);
        }
    }
}
