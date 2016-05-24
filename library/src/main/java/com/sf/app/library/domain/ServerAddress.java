package com.sf.app.library.domain;

public class ServerAddress {
    public final String host;
    public final int port;

    public ServerAddress(String host, int port) {
        this.host = host;
        this.port = port;
    }
}