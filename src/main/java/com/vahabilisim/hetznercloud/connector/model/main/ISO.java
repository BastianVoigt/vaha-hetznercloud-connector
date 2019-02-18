package com.vahabilisim.hetznercloud.connector.model.main;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.vahabilisim.hetznercloud.connector.model.IDInterface;
import lombok.Data;
import java.util.Date;
import java.util.stream.Stream;

@Data
public class ISO implements IDInterface {

    private long id;
    private String name;
    private String description;
    private Type type;
    private Date deprecated;

    public static enum Type {

        PUBLIC("public"),
        PRIVATE("private"),
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
