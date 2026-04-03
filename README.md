# Java Multithreading Examples

This project contains various examples demonstrating multithreading concepts in Java. It is organized as a Java module with different packages for each topic.

## Prerequisites

- Java 11 or higher
- A Java IDE or command line tools

## Structure

The project is divided into the following modules:

- **CompleteableFuture**: Examples using CompletableFuture for asynchronous programming.
- **CustomLocks**: Demonstrations of different lock mechanisms:
  - ReadWriteLock: Using ReadWriteLock for concurrent read/write access.
  - ReentrantLock: Examples with ReentrantLock.
  - Semaphore: Controlling access to resources with semaphores.
  - StamedLock: Using StampedLock (note: likely a typo for StampedLock).
  - StampedLockOptmistic: Optimistic locking with StampedLock.
- **DeadLockExample**: Illustrates deadlock scenarios and how to avoid them.
- **ForkJoin**: Using the Fork/Join framework for parallel processing.
- **MonitorLockExample**: Synchronization using monitor locks.
- **MultiThreading**: Basic multithreading concepts.
- **ProducerConsumerProblem**: Classic producer-consumer problem implementation.
- **ThreadCreationWays**: Different ways to create threads in Java.
- **ThreadExecutorPool**: Using ExecutorService for thread pools.
- **ThreadLifeCycle**: Demonstrating the lifecycle of threads.

## How to Run

1. Compile the module:
   ```
   javac -d bin --module-path . src/module-info.java src/**/*.java
   ```

2. Run a specific example (replace `ExamplePackage.Main` with the actual class):
   ```
   java --module-path bin -m MultiThreading/ExamplePackage.Main
   ```

For example, to run the basic MultiThreading example:
```
java --module-path bin -m MultiThreading/MultiThreading.Main
```

## Contributing

Feel free to add more examples or improve existing ones.
