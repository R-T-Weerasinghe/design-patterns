package com.example;

public class Singleton {
    // private and static instance, volatile prevents caching
    private static volatile Singleton instance;

    // uncallable constructor
    private Singleton() {}


    public static Singleton getInstance() {
        // lazy initialization with double checked locking (for thread safety)
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}