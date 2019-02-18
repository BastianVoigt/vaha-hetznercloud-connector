package com.vahabilisim.hetznercloud.connector.model.main;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.vahabilisim.hetznercloud.connector.model.IDInterface;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;
import lombok.Data;

@Data
public class Action implements IDInterface{

    private long id;
    private String command;
    private Status status;
    private int progress;
    private Date started;
    private Date finished;
    private List<Resource> resources;
    private Error error;

    @Data
    public static class Error {

        private String code;
        private String message;
    }

    public static enum Status {

        SUCCESS("success"),
        RUNNING("running"),
        ERROR("error"),
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

    @Data
    public static class Resource {

        private long id;
        private Type type;

        public static enum Type {

            SERVER("server"),
            FLOATING_IP("floating_ip"),
            IMAGE("image"),
            VOLUME("volume"),
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
}
