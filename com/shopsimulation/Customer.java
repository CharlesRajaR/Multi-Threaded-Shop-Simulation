package com.shopsimulation;

import java.util.*;

// class Customer implements Runnable{
//     private Shop shop;
//     private Random random = new Random();

//     Customer(Shop shop){
//         this.shop = shop;
//     }

//     @Override
//     public void run(){
//        while(true){
//         int qt = random.nextInt(100) + 1;
//         int choice = random.nextInt(2);

//         if(choice == 0){
//             shop.buyRice(qt);
//         }
//         else{
//             shop.buyOil(qt);
//         }

//         try{
//             Thread.sleep(300);
//         }catch(InterruptedException e){
//             e.printStackTrace();
//         }
//        }
//     }
// }

class Customer extends ShopWorker {
    Customer(Shop shop) { this.shop = shop; }

    @Override
    public void run() {
        while (running) {
            int qt = random.nextInt(5) + 1;
            if (random.nextInt(2) == 0) shop.buyRice(qt);
            else shop.buyChocolate(qt);

            try { Thread.sleep(50); } 
            catch (InterruptedException e) { break; }
        }
        System.out.println(Thread.currentThread().getName() + " stopped.");
    }
}