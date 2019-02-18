package com.vahabilisim.hetznercloud.connector.model.main;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.vahabilisim.hetznercloud.connector.model.common.PriceServerType;
import com.vahabilisim.hetznercloud.connector.model.IDInterface;
import lombok.Data;
import java.util.List;
import java.util.stream.Stream;

@Data
public class ServerType implements IDInterface {

    private long id;
    private String name;
    private String description;
    private long cores;
    private long memory;
    private long disk;
    private List<PriceServerType> prices;
    @JsonProperty("storage_type")
    private StorageType storageType;
    @JsonProperty("cpu_type")
    private CpuType cpuType;

    public static enum StorageType {

        LOCAL("local"),
        NETWORK("network"),
        UNKNOWN("unknown");

        public final String value;

        private StorageType(String value) {
            this.value = value;
        }

        @JsonValue
        public String value() {
            return value;
        }

        @JsonCreator
        public static StorageType creator(String value) {
            return Stream.of(values()).filter(enu -> enu.value.equals(value)).findFirst().orElse(UNKNOWN);
        }
    }

    public static enum CpuType {

        SHARED("shared"),
        DEDICATED("dedicated"),
        UNKNOWN("unknown");

        public final String value;

        private CpuType(String value) {
            this.value = value;
        }

        @JsonValue
        public String value() {
            return value;
        }

        @JsonCreator
        public static CpuType creator(String value) {
            return Stream.of(values()).filter(enu -> enu.value.equals(value)).findFirst().orElse(UNKNOWN);
        }
    }
}
