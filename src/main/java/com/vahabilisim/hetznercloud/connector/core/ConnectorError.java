package com.vahabilisim.hetznercloud.connector.core;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.stream.Stream;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
//@JsonIgnoreProperties(ignoreUnknown = true)
public class ConnectorError {

    private Code code;
    private String message;
    private JsonNode details;

    public static enum Code {

        HTTP_ERROR("http_error"),
        FORBIDDEN("forbidden"),
        INVALID_INPUT("invalid_input"),
        JSON_ERROR("json_error"),
        LOCKED("locked"),
        NOT_FOUND("not_found"),
        RATE_LIMIT_EXCEEDED("rate_limit_exceeded"),
        RESOURCE_LIMIT_EXCEEDED("resource_limit_exceeded"),
        RESOURCE_UNAVAILABLE("resource_unavailable"),
        SERVICE_ERROR("service_error"),
        UNIQUENESS_ERROR("uniqueness_error"),
        PROTECTED("protected"),
        MAINTENANCE("maintenance"),
        UNKNOWN("unknown");

        public final String value;

        private Code(String value) {
            this.value = value;
        }

        @JsonValue
        public String value() {
            return value;
        }

        @JsonCreator
        public static Code creator(String value) {
            return Stream.of(values()).filter(enu -> enu.value.equals(value)).findFirst().orElse(UNKNOWN);
        }

    }

}
