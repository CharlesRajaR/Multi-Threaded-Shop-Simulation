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
Customer-1 failed to buy Chocolate. Shortage!
Customer-2 failed to buy Chocolate. Shortage!
Customer-4 failed to buy Chocolate. Shortage!
Customer-5 failed to buy Chocolate. Shortage!
Supplier-1 supplying RICE: +63 | Before: 0
Customer-2 failed to buy Chocolate. Shortage!
Customer-3 bought 5 Rice. Stock now: 58      
Customer-4 bought 5 Rice. Stock now: 53      
Customer-5 bought 5 Rice. Stock now: 48      
Customer-1 bought 3 Rice. Stock now: 45      
Customer-1 failed to buy Chocolate. Shortage!
Customer-5 bought 3 Rice. Stock now: 42
Customer-4 bought 5 Rice. Stock now: 37
Customer-3 bought 5 Rice. Stock now: 32
Customer-2 bought 3 Rice. Stock now: 29
Customer-1 failed to buy Chocolate. Shortage!
Supplier-1 supplying RICE: +94 | Before: 29
Customer-5 failed to buy Chocolate. Shortage!
Customer-4 bought 1 Rice. Stock now: 122
Customer-2 failed to buy Chocolate. Shortage!
Customer-3 bought 1 Rice. Stock now: 121
Customer-1 failed to buy Chocolate. Shortage!
Customer-2 bought 3 Rice. Stock now: 118
Customer-4 failed to buy Chocolate. Shortage!
Supplier-1 supplying RICE: +99 | Before: 118
Customer-5 failed to buy Chocolate. Shortage!
Customer-1 bought 1 Rice. Stock now: 216
Customer-2 failed to buy Chocolate. Shortage!
Customer-3 bought 5 Rice. Stock now: 211
Customer-4 failed to buy Chocolate. Shortage!
Customer-5 bought 2 Rice. Stock now: 209
Supplier-1 supplying CHOCOLATE: +18 | Before: 0
Customer-3 bought 4 Chocolate. Stock now: 14
Customer-2 bought 5 Rice. Stock now: 204
Customer-1 bought 4 Chocolate. Stock now: 10
Customer-4 bought 1 Rice. Stock now: 203
Customer-5 bought 3 Chocolate. Stock now: 7
Supplier-1 supplying CHOCOLATE: +10 | Before: 7
Customer-3 bought 2 Chocolate. Stock now: 15
Customer-2 bought 3 Chocolate. Stock now: 12
Customer-5 bought 1 Chocolate. Stock now: 11
Customer-4 bought 1 Rice. Stock now: 202
Customer-1 bought 1 Chocolate. Stock now: 10
Customer-2 bought 3 Rice. Stock now: 199
Customer-3 bought 2 Rice. Stock now: 197
Supplier-1 supplying RICE: +100 | Before: 197
Customer-5 bought 3 Rice. Stock now: 294
Customer-2 bought 5 Chocolate. Stock now: 5
Customer-1 bought 3 Rice. Stock now: 291
Customer-3 bought 4 Chocolate. Stock now: 1
Customer-4 bought 1 Rice. Stock now: 290
Customer-5 bought 2 Rice. Stock now: 288
Supplier-1 supplying CHOCOLATE: +74 | Before: 1
Supplier-1 supplying CHOCOLATE: +74 | Before: 1
Customer-2 bought 2 Rice. Stock now: 286
Customer-3 bought 2 Chocolate. Stock now: 73
Customer-1 bought 3 Chocolate. Stock now: 70

******************************************
 ANNOUNCEMENT: CLOSING THE SHOP SOON...
******************************************

Supplier-1 supplying CHOCOLATE: +74 | Before: 1
Customer-2 bought 2 Rice. Stock now: 286
Customer-3 bought 2 Chocolate. Stock now: 73
Customer-1 bought 3 Chocolate. Stock now: 70

******************************************
 ANNOUNCEMENT: CLOSING THE SHOP SOON...
******************************************

Customer-5 bought 2 Chocolate. Stock now: 68
Customer-5 stopped.
Customer-4 bought 5 Rice. Stock now: 281
Customer-4 stopped.
Supplier-1 stopped.
Customer-1 stopped.
Customer-2 stopped.
Customer-3 stopped.
Customer-5 bought 2 Chocolate. Stock now: 68
Customer-5 stopped.
Customer-4 bought 5 Rice. Stock now: 281
Customer-4 stopped.
Customer-4 bought 5 Rice. Stock now: 281
Customer-4 stopped.
Customer-4 stopped.
Supplier-1 stopped.
Customer-1 stopped.
Customer-2 stopped.
Customer-3 stopped.

--- All Operations Finished ---

Final Rice Stock = 281
Final Chocolate Stock = 68
```



