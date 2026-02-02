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



