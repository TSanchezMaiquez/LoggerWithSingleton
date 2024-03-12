package com.kreitek.pets.infraestructure.bd;

public class Logger {

    private static volatile Logger instance = null;
    private int count = 0;


    private Logger() {
        if (instance != null) {
            throw new RuntimeException("Usage getInstance() method to create");
        }
    }
    public static Logger getInstance() {
        if (instance == null) {
            synchronized(DbService.class) {
                if (instance == null) {
                    instance = new Logger();
                }
            }
        }
        return instance;
    }
    public void debug(String action){
        count++;
        System.out.println("[debug][" + count + "]" + action);
    }
}
