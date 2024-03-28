package com.singleton;

public class ConnectionManager {
    private static ConnectionManager instance;

    private ConnectionManager() {
        //private constructor to avoid instantiation
    }
    
    public static synchronized ConnectionManager getInstance() {
        if (instance == null) {
            instance = new ConnectionManager();
        }
        return instance;
    }

    public void connect() {
        System.out.println("Establishing connection to the external system...");
    }
}
