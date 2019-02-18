package com.vahabilisim.hetznercloud.connector.core;

public class ConnectorException extends RuntimeException {

    public final ConnectorError error;

    public ConnectorException(ConnectorError error) {
        super(String.format("%s - %s", error.getCode(), error.getMessage()));
        this.error = error;
    }

    public ConnectorException(ConnectorError error, Throwable cause) {
        super(String.format("%s - %s", error.getCode(), error.getMessage()), cause);
        this.error = error;
    }

}
