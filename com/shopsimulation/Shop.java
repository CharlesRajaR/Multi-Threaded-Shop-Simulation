package com.shopsimulation;

import java.util.*;
import java.util.concurrent.locks.ReentrantLock;

class Shop {
    private int riceStock = 0;
    private int chocolateStock = 0;
    private final ReentrantLock riceLock = new ReentrantLock();
    private final ReentrantLock chocolateLock = new ReentrantLock();

    public void supplyRice(int qty) {
        riceLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " supplying RICE: +" + qty + " | Before: " + riceStock);
            this.riceStock += qty;
        } finally {
            riceLock.unlock();
        }
    }

    public void supplyChocolate(int qty) {
        chocolateLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " supplying CHOCOLATE: +" + qty + " | Before: " + chocolateStock);
            this.chocolateStock += qty;
        } finally {
            chocolateLock.unlock();
        }
    }

    public void buyRice(int qty) {
        riceLock.lock();
        try {
            if (this.riceStock >= qty) {
                this.riceStock -= qty;
                System.out.println(Thread.currentThread().getName() + " bought " + qty + " Rice. Stock now: " + riceStock);
            } else {
                System.out.println(Thread.currentThread().getName() + " failed to buy Rice. Shortage!");
            }
        } finally {
            riceLock.unlock();
        }
    }

    public void buyChocolate(int qty) {
        chocolateLock.lock();
        try {
            if (this.chocolateStock >= qty) {
                this.chocolateStock -= qty;
                System.out.println(Thread.currentThread().getName() + " bought " + qty + " Chocolate. Stock now: " + chocolateStock);
            } else {
                System.out.println(Thread.currentThread().getName() + " failed to buy Chocolate. Shortage!");
            }
        } finally {
            chocolateLock.unlock();
        }
    }

    public int getRiceStock() { return riceStock; }
    public int getChocolateStock() { return chocolateStock; }
}

