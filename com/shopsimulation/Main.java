package com.shopsimulation;

import java.util.*;
import java.util.concurrent.locks.ReentrantLock;

public class Main{
    public static void main(String[] args){
        // Shop shop = new Shop();
        // shop.supplyRice(5);
        // shop.supplyOil(5);
        // shop.buyRice(3);
        // shop.buyOil(3); 
        // shop.buyRice(3);
        // System.out.println("Rice Stock Status: "+shop.getRiceStock());
        // shop.buyOil(2);

        // Random random = new Random();
        // for(int i = 0; i < 100; i++){
        //     System.out.print(random.nextInt(10) + 1);
        //     System.out.print(" ");
        //     if(i % 10 == 0 && i > 0){
        //         System.out.println();
        //     }
        // }
        // System.out.println(random.nextInt(100));

        Shop shop = new Shop();

        System.out.println("Initial Rice Stock = " + shop.getRiceStock());
        System.out.println("Initial Chocolate Stock = " + shop.getChocolateStock());

        // Start Supplier
        Supplier supplier = new Supplier(shop);
        Thread supplierThread = new Thread(supplier, "Supplier-1");
        supplierThread.start();

        // Start Customers
        List<Customer> customerList = new ArrayList<>();
        List<Thread> threadList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Customer c = new Customer(shop);
            customerList.add(c);
            Thread t = new Thread(c, "Customer-" + (i + 1));
            threadList.add(t);
            t.start();
        }

        // LET THE SIMULATION RUN FOR 2 SECONDS
        try{
            Thread.sleep(2000);
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
        

        System.out.println("\n******************************************\n ANNOUNCEMENT: CLOSING THE SHOP SOON... \n******************************************\n");

        // STOP LOGIC:
        // supplier.stopSupplier();
        supplier.stopWorker();
        supplierThread.interrupt(); // Wake it up from sleep to exit fast

        for (int i = 0; i < customerList.size(); i++) {
            customerList.get(i).stopWorker();
            threadList.get(i).interrupt();
        }

        // Wait for all threads to finish their current work
        try{
            supplierThread.join();
            for (Thread t : threadList) t.join();
        }catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\n--- All Operations Finished ---\n");
        System.out.println("Final Rice Stock = " + shop.getRiceStock());
        System.out.println("Final Chocolate Stock = " + shop.getChocolateStock());
    }
}