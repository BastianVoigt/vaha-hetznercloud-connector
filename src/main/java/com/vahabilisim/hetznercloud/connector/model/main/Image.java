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
public class Image implements IDInterface {

    private long id;
    private Type type;
    private Status status;
    private String name;
    private String description;
    @JsonProperty("image_size")
    private double imageSize;
    @JsonProperty("disk_size")
    private double diskSize;
    private Date created;
    @JsonProperty("created_from")
    private CreatedFrom createdFrom;
    @JsonProperty("bound_to")
    private long boundTo;
    @JsonProperty("os_flavor")
    private OSFlavor osFlavor;
    @JsonProperty("os_version")
    private String osVersion;
    @JsonProperty("rapid_deploy")
    private boolean rapidDeploy;
    private Protection protection;
    private Date deprecated;
    private Map<String, String> labels;

    @Data
    public static class CreatedFrom {

        private long id;
        private String name;
    }

    public static enum Type {

        SYSTEM("system"),
        SNAPSHOT("snapshot"),
        BACKUP("backup"),
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

    public static enum OSFlavor {

        UBUNTU("ubuntu"),
        CENTOS("centos"),
        DEBIAN("debian"),
        FEDORA("fedora"),
        UNKNOWN("unknown");

        public final String value;

        private OSFlavor(String value) {
            this.value = value;
        }

        @JsonValue
        public String value() {
            return value;
        }

        @JsonCreator
        public static OSFlavor creator(String value) {
            return Stream.of(values()).filter(enu -> enu.value.equals(value)).findFirst().orElse(UNKNOWN);
        }
    }
}
