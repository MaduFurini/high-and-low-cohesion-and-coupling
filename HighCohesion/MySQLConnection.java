package HighCohesion;

import java.sql.Connection;

public class MySQLConnection {
    private String host;
    private int port;
    private Connection conn;

    public void connect() {
        System.out.println("Connecting to the database...");
    }

    public void disconnect() {
        System.out.println("Disconnecting to the database...");
    }

    public void isAcitve() {
        System.out.println("Getting database status...");
    }
}
