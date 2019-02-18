package com.vahabilisim.hetznercloud.connector.model.common;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.stream.Stream;

public enum RescueSystem {

    LINUX_32("linux32"),
    LINUX_64("linux64"),
    FREEBSD_64("freebsd64"),
    UNKNOWN("unknown");

    public final String value;

    private RescueSystem(String value) {
        this.value = value;
    }

    @JsonValue
    public String value() {
        return value;
    }

    @JsonCreator
    public static RescueSystem creator(String value) {
        return Stream.of(values()).filter(enu -> enu.value.equals(value)).findFirst().orElse(UNKNOWN);
    }
}
