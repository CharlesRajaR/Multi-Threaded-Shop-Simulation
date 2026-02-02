package com.shopsimulation;

import java.util.*;

// class Supplier implements Runnable{
//     private Shop shop;
//     private Random random = new Random();

//     Supplier(Shop shop){
//         this.shop = shop;
//     }

//     @Override
//     public void run(){
//         while(true){
//             int qt = random.nextInt(100) + 1;
//             int choice = random.nextInt(2);
//             if(choice == 0){
//                 shop.supplyRice(qt);
//             }
//             else{
//                 shop.supplyOil(qt);
//             }

//             try{
//                 Thread.sleep(3000);
//             }
//             catch(InterruptedException e){
//                 e.printStackTrace();
//             }
//         }
//     }
// }

class Supplier extends ShopWorker {
    Supplier(Shop shop) { this.shop = shop; }

    @Override
    public void run() {
        while (running) { 
            int qt = random.nextInt(100) + 1;
            if (random.nextInt(2) == 0) shop.supplyRice(qt);
            else shop.supplyChocolate(qt);

            try { Thread.sleep(100); } 
            catch (InterruptedException e) { break; } // Exit if interrupted
        }
        System.out.println(Thread.currentThread().getName() + " stopped.");
    }
}