package com.shopsimulation;

import java.util.*;

class ShopWorker implements Runnable {
    protected Shop shop;
    protected Random random = new Random();
    protected volatile boolean running = true; 

    public void stopWorker() {
        this.running = false;
    }

    @Override
    public void run() {
        // Logic will be implemented by Supplier and Customer subclasses
    }
}

