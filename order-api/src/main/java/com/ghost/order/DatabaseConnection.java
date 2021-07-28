package com.ghost.order;

public class DatabaseConnection {

    private String host;
    private String username;

    public DatabaseConnection connection(String host, String username){
        this.host = host;
        this.username = username;
        return new DatabaseConnection();
    }

    public Object query(String query){
        return null;
    }
}
