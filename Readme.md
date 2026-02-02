# Multi-Threaded Shop Simulation

A Java-based simulation of a retail environment where multiple threads interact with a shared inventory. This project demonstrates advanced **Concurrency Control** using `ReentrantLock` to prevent data corruption during simultaneous "Supply" and "Buy" operations.

## Key Features
* **Thread Safety:** Uses `ReentrantLock` for fine-grained locking. Rice and Chocolate have independent locks, allowing customers to buy different items simultaneously.
* **Producer-Consumer Pattern:** A `Supplier` thread adds stock while multiple `Customer` threads remove it in real-time.
* **Graceful Shutdown:** Implements a `volatile` boolean flag and `interrupt()` signal to close the shop safely, ensuring all threads exit the loop cleanly.
* **Randomized Logic:** Uses the `Random` class to simulate unpredictable market demand and delivery quantities.

## Technical Concepts Used
* **`ReentrantLock`**: Used instead of standard `synchronized` blocks for better control and the ability to use `tryLock()` if needed.
* **`Runnable` Interface**: Separates the task logic (Supplier/Customer) from the thread execution.
* **`Thread.join()`**: Ensures the Main thread waits for all background workers to complete their final transactions before printing the final report.
* **Volatile Variables**: Guarantees that the `running` flag is updated across all CPU caches immediately when the "Closing" announcement is made.



---

## Project Structure
To maintain package integrity, ensure your files are organized as follows:
```text
ProjectFolder/
└── com/
    └── shopsimulation/
        └── Main.java  
        └── Shop.java 
        └── ShopWorker.java 
        └── Supplier.java 
        └── Customer.java 
    └── Readme.md 
```

---


## How to Run the Simulation

To run this simulation correctly via the terminal, you must follow the package-compliant commands below.

### 1. Open your Terminal
Navigate to the **root directory** (the parent folder that contains the `com` folder).

### 2. Compile the Program
Use the Java Compiler to build the project
```bash
javac com/shopsimulation/Main.java
```

### 3. Execute the Simnulation:
Run the program using the following command
```bash
java com/shopsimulation/Main
```

## Output

```text
Initial Rice Stock = 0
Initial Chocolate Stock = 0
Customer-1 failed to buy Rice. Shortage!
Customer-2 failed to buy Rice. Shortage!
Customer-4 failed to buy Rice. Shortage!
Customer-4 failed to buy Rice. Shortage!
Supplier-1 supplying CHOCOLATE: +92 | Before: 0
Customer-2 failed to buy Rice. Shortage!       
Customer-3 bought 2 Chocolate. Stock now: 90   
Customer-5 bought 5 Chocolate. Stock now: 85   
Customer-1 bought 1 Chocolate. Stock now: 84   
Customer-3 failed to buy Rice. Shortage!
Customer-2 bought 3 Chocolate. Stock now: 81
Customer-4 bought 4 Chocolate. Stock now: 77
Customer-1 failed to buy Rice. Shortage!    
Customer-5 bought 1 Chocolate. Stock now: 76
Customer-2 bought 5 Chocolate. Stock now: 71
Supplier-1 supplying RICE: +38 | Before: 0  
Customer-3 bought 5 Chocolate. Stock now: 66
Customer-4 bought 2 Rice. Stock now: 36     
Customer-1 bought 4 Chocolate. Stock now: 62
Customer-5 bought 5 Rice. Stock now: 31     
Customer-3 bought 5 Chocolate. Stock now: 57
Customer-1 bought 5 Rice. Stock now: 26
Customer-4 bought 1 Chocolate. Stock now: 56
Customer-2 bought 3 Rice. Stock now: 23
Customer-5 bought 1 Chocolate. Stock now: 55
Supplier-1 supplying RICE: +43 | Before: 23
Customer-3 bought 2 Rice. Stock now: 64
Customer-4 bought 2 Chocolate. Stock now: 53
Customer-1 bought 1 Rice. Stock now: 63
Customer-5 bought 3 Chocolate. Stock now: 50
Customer-2 bought 2 Chocolate. Stock now: 48
Customer-1 bought 5 Rice. Stock now: 58
Supplier-1 supplying CHOCOLATE: +47 | Before: 48
Customer-4 bought 5 Chocolate. Stock now: 90
Customer-3 bought 2 Chocolate. Stock now: 88
Customer-5 bought 3 Chocolate. Stock now: 85
Customer-4 bought 2 Chocolate. Stock now: 83
Customer-5 bought 4 Chocolate. Stock now: 79
Supplier-1 supplying CHOCOLATE: +97 | Before: 79
Customer-4 bought 4 Chocolate. Stock now: 172
Customer-5 bought 5 Chocolate. Stock now: 167
Supplier-1 supplying CHOCOLATE: +44 | Before: 167
Supplier-1 supplying CHOCOLATE: +80 | Before: 211
Customer-3 bought 1 Rice. Stock now: 57
Customer-1 bought 3 Chocolate. Stock now: 288
Customer-4 bought 3 Rice. Stock now: 54
Customer-5 bought 5 Rice. Stock now: 49
Customer-2 bought 4 Rice. Stock now: 45
Customer-5 bought 1 Chocolate. Stock now: 287
Customer-4 bought 4 Rice. Stock now: 41
Customer-3 bought 4 Chocolate. Stock now: 283
Customer-1 bought 1 Rice. Stock now: 40
Supplier-1 supplying CHOCOLATE: +82 | Before: 283
Customer-2 bought 1 Rice. Stock now: 39
Customer-1 bought 5 Rice. Stock now: 34
Customer-4 bought 3 Chocolate. Stock now: 362
Customer-3 bought 1 Rice. Stock now: 33
Customer-5 bought 4 Chocolate. Stock now: 358
Customer-2 bought 2 Chocolate. Stock now: 356
Customer-5 bought 1 Rice. Stock now: 32
Customer-3 bought 4 Chocolate. Stock now: 352
Customer-4 bought 3 Rice. Stock now: 29
Customer-1 bought 1 Chocolate. Stock now: 351
Supplier-1 supplying CHOCOLATE: +91 | Before: 351
Customer-2 bought 1 Rice. Stock now: 28
Customer-4 bought 3 Chocolate. Stock now: 439
Customer-1 bought 2 Rice. Stock now: 26
Customer-3 bought 3 Chocolate. Stock now: 436
Customer-5 bought 5 Chocolate. Stock now: 431
Customer-2 bought 3 Rice. Stock now: 23
Supplier-1 supplying CHOCOLATE: +46 | Before: 431
Customer-3 bought 4 Rice. Stock now: 19
Customer-1 bought 2 Chocolate. Stock now: 475
Customer-4 bought 3 Chocolate. Stock now: 472
Customer-5 bought 4 Rice. Stock now: 15
Customer-2 bought 3 Rice. Stock now: 12
Customer-4 bought 4 Rice. Stock now: 8
Customer-5 bought 4 Chocolate. Stock now: 468
Customer-1 bought 5 Rice. Stock now: 3
Customer-3 bought 2 Rice. Stock now: 1
Customer-2 failed to buy Rice. Shortage!
Supplier-1 supplying CHOCOLATE: +69 | Before: 468
Customer-3 failed to buy Rice. Shortage!
Customer-5 bought 2 Chocolate. Stock now: 535
Customer-1 failed to buy Rice. Shortage!
Customer-4 bought 2 Chocolate. Stock now: 533
Customer-2 failed to buy Rice. Shortage!
Customer-3 failed to buy Rice. Shortage!
Customer-5 bought 1 Rice. Stock now: 0
Customer-2 bought 3 Chocolate. Stock now: 530
Customer-4 failed to buy Rice. Shortage!
Customer-1 failed to buy Rice. Shortage!
Supplier-1 supplying RICE: +90 | Before: 0
Customer-3 bought 1 Chocolate. Stock now: 529
Customer-2 bought 2 Chocolate. Stock now: 527
Customer-5 bought 2 Rice. Stock now: 88
Customer-4 bought 5 Chocolate. Stock now: 522
Customer-1 bought 1 Chocolate. Stock now: 521
Customer-3 bought 5 Rice. Stock now: 83
Customer-1 bought 5 Rice. Stock now: 78
Customer-5 bought 5 Chocolate. Stock now: 516
Customer-4 bought 3 Rice. Stock now: 75
Supplier-1 supplying RICE: +70 | Before: 75
Customer-2 bought 5 Rice. Stock now: 140
Customer-3 bought 4 Rice. Stock now: 136
Customer-4 bought 4 Rice. Stock now: 132
Customer-5 bought 5 Chocolate. Stock now: 511
Customer-2 bought 4 Rice. Stock now: 128
Customer-1 bought 1 Chocolate. Stock now: 510
Customer-3 bought 2 Chocolate. Stock now: 508
Supplier-1 supplying RICE: +63 | Before: 128
Customer-4 bought 2 Rice. Stock now: 189
Customer-3 bought 2 Rice. Stock now: 187
Customer-2 bought 2 Chocolate. Stock now: 506
Customer-1 bought 3 Rice. Stock now: 184
Customer-5 bought 1 Rice. Stock now: 183
Customer-4 bought 3 Chocolate. Stock now: 503
Customer-3 bought 4 Rice. Stock now: 179
Customer-2 bought 2 Chocolate. Stock now: 501
Customer-1 bought 3 Rice. Stock now: 176
Customer-5 bought 2 Chocolate. Stock now: 499
Supplier-1 supplying CHOCOLATE: +43 | Before: 499
Customer-4 bought 5 Chocolate. Stock now: 537

******************************************
 ANNOUNCEMENT: CLOSING THE SHOP SOON...
******************************************

Supplier-1 stopped.
Customer-1 stopped.
Customer-2 stopped.
Customer-4 stopped.
Customer-5 stopped.
Customer-3 stopped.

--- All Operations Finished ---

Final Rice Stock = 176
Final Chocolate Stock = 537
```