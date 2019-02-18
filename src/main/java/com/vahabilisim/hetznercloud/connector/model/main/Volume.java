package com.vahabilisim.hetznercloud.connector.model.main;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.vahabilisim.hetznercloud.connector.model.common.Protection;
import com.vahabilisim.hetznercloud.connector.model.IDInterface;
import lombok.Data;
import java.util.Date;
import java.util.Map;
import java.util.stream.Stream;

@Data
public class Volume implements IDInterface {

    private long id;
    private Date created;
    private String name;
    private long server;
    private Location location;
    private long size;
    @JsonProperty("linux_device")
    private String linuxDevice;
    private Protection protection;
    private Map<String, String> labels;
    private Status status;
    private Format format;

    public static enum Status {

        CREATING("creating"),
        AVAILABLE("available"),
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

    public static enum Format {

        XFS("xfs"),
        EXT4("ext4"),
        UNKNOWN("unknown");

        public final String value;

        private Format(String value) {
            this.value = value;
        }

        @JsonValue
        public String value() {
            return value;
        }

        @JsonCreator
        public static Format creator(String value) {
            return Stream.of(values()).filter(enu -> enu.value.equals(value)).findFirst().orElse(UNKNOWN);
        }
    }
}
