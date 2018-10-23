### AbstractQueuedSynchronizer（AQS）



它为阻塞锁和相关的同步器（semaphores, events, etc）提供了一个框架，依赖的主要是一个先入先出的等待队列。设计这个类的目的是让他称为大多同步器的有用的基础类，这些同步器用一个原子整形（atomicInteger）来表示同步器的状态。子类必须实现他的一个protected methods来改变这个原子整数型的值，而不同的值代表着不同的状态（是获得锁 还是释放锁）。这个类里面的其他的方法执行所有的排队和阻塞机制都是基于上述的理论的。子类也可以维护其他的状态值，但是只有原子更新的 整数值来表示同步状态，这个原子整数值是通过以下几个方法来维护的

```
setState(int)，getState(),compareAndSetState(int, int)
```

 Subclasses should be defined as non-public internal helper classes that are used to implement the synchronization properties of their enclosing class. Class`AbstractQueuedSynchronizer` does not implement any synchronization interface. Instead it defines methods such as [`acquireInterruptibly(int)`](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/locks/AbstractQueuedSynchronizer.html#acquireInterruptibly-int-) that can be invoked as appropriate by concrete locks and related synchronizers to implement their public methods.

This class supports either or both a default *exclusive* mode and a *shared* mode. When acquired in exclusive mode, attempted acquires by other threads cannot succeed. Shared mode acquires by multiple threads may (but need not) succeed. This class does not "understand" these differences except in the mechanical sense that when a shared mode acquire succeeds, the next waiting thread (if one exists) must also determine whether it can acquire as well. Threads waiting in the different modes share the same FIFO queue. Usually, implementation subclasses support only one of these modes, but both can come into play for example in a [`ReadWriteLock`](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/locks/ReadWriteLock.html). Subclasses that support only exclusive or only shared modes need not define the methods supporting the unused mode.

This class defines a nested [`AbstractQueuedSynchronizer.ConditionObject`](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/locks/AbstractQueuedSynchronizer.ConditionObject.html) class that can be used as a [`Condition`](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/locks/Condition.html) implementation by subclasses supporting exclusive mode for which method [`isHeldExclusively()`](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/locks/AbstractQueuedSynchronizer.html#isHeldExclusively--) reports whether synchronization is exclusively held with respect to the current thread, method [`release(int)`](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/locks/AbstractQueuedSynchronizer.html#release-int-) invoked with the current [`getState()`](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/locks/AbstractQueuedSynchronizer.html#getState--) value fully releases this object, and [`acquire(int)`](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/locks/AbstractQueuedSynchronizer.html#acquire-int-), given this saved state value, eventually restores this object to its previous acquired state. No `AbstractQueuedSynchronizer` method otherwise creates such a condition, so if this constraint cannot be met, do not use it. The behavior of [`AbstractQueuedSynchronizer.ConditionObject`](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/locks/AbstractQueuedSynchronizer.ConditionObject.html) depends of course on the semantics of its synchronizer implementation.

This class provides inspection, instrumentation, and monitoring methods for the internal queue, as well as similar methods for condition objects. These can be exported as desired into classes using an `AbstractQueuedSynchronizer` for their synchronization mechanics.

Serialization of this class stores only the underlying atomic integer maintaining state, so deserialized objects have empty thread queues. Typical subclasses requiring serializability will define a `readObject` method that restores this to a known initial state upon deserialization.

### Usage

To use this class as the basis of a synchronizer, redefine the following methods, as applicable, by inspecting and/or modifying the synchronization state using [`getState()`](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/locks/AbstractQueuedSynchronizer.html#getState--), [`setState(int)`](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/locks/AbstractQueuedSynchronizer.html#setState-int-) and/or [`compareAndSetState(int, int)`](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/locks/AbstractQueuedSynchronizer.html#compareAndSetState-int-int-):

- [`tryAcquire(int)`](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/locks/AbstractQueuedSynchronizer.html#tryAcquire-int-)
- [`tryRelease(int)`](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/locks/AbstractQueuedSynchronizer.html#tryRelease-int-)
- [`tryAcquireShared(int)`](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/locks/AbstractQueuedSynchronizer.html#tryAcquireShared-int-)
- [`tryReleaseShared(int)`](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/locks/AbstractQueuedSynchronizer.html#tryReleaseShared-int-)
- [`isHeldExclusively()`](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/locks/AbstractQueuedSynchronizer.html#isHeldExclusively--)

Each of these methods by default throws 

```
UnsupportedOperationException
```

. Implementations of these methods must be internally thread-safe, and should in general be short and not block. Defining these methods is the 

only

 supported means of using this class. All other methods are declared 

```
final
```

 because they cannot be independently varied.

You may also find the inherited methods from [`AbstractOwnableSynchronizer`](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/locks/AbstractOwnableSynchronizer.html) useful to keep track of the thread owning an exclusive synchronizer. You are encouraged to use them -- this enables monitoring and diagnostic tools to assist users in determining which threads hold locks.

Even though this class is based on an internal FIFO queue, it does not automatically enforce FIFO acquisition policies. The core of exclusive synchronization takes the form:

```java
 Acquire:
     while (!tryAcquire(arg)) {
        enqueue thread if it is not already queued;
        possibly block current thread;
     }

 Release:
     if (tryRelease(arg))
        unblock the first queued thread;
 
```

(Shared mode is similar but may involve cascading signals.)

Because checks in acquire are invoked before enqueuing, a newly acquiring thread may *barge* ahead of others that are blocked and queued. However, you can, if desired, define `tryAcquire` and/or `tryAcquireShared` to disable barging by internally invoking one or more of the inspection methods, thereby providing a *fair*FIFO acquisition order. In particular, most fair synchronizers can define `tryAcquire` to return `false` if [`hasQueuedPredecessors()`](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/locks/AbstractQueuedSynchronizer.html#hasQueuedPredecessors--) (a method specifically designed to be used by fair synchronizers) returns `true`. Other variations are possible.

Throughput and scalability are generally highest for the default barging (also known as *greedy*, *renouncement*, and *convoy-avoidance*) strategy. While this is not guaranteed to be fair or starvation-free, earlier queued threads are allowed to recontend before later queued threads, and each recontention has an unbiased chance to succeed against incoming threads. Also, while acquires do not "spin" in the usual sense, they may perform multiple invocations of `tryAcquire`interspersed with other computations before blocking. This gives most of the benefits of spins when exclusive synchronization is only briefly held, without most of the liabilities when it isn't. If so desired, you can augment this by preceding calls to acquire methods with "fast-path" checks, possibly prechecking [`hasContended()`](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/locks/AbstractQueuedSynchronizer.html#hasContended--) and/or [`hasQueuedThreads()`](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/locks/AbstractQueuedSynchronizer.html#hasQueuedThreads--) to only do so if the synchronizer is likely not to be contended.

This class provides an efficient and scalable basis for synchronization in part by specializing its range of use to synchronizers that can rely on `int` state, acquire, and release parameters, and an internal FIFO wait queue. When this does not suffice, you can build synchronizers from a lower level using [`atomic`](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/atomic/package-summary.html) classes, your own custom [`Queue`](https://docs.oracle.com/javase/8/docs/api/java/util/Queue.html) classes, and [`LockSupport`](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/locks/LockSupport.html) blocking support.

### Usage Examples

Here is a non-reentrant mutual exclusion lock class that uses the value zero to represent the unlocked state, and one to represent the locked state. While a non-reentrant lock does not strictly require recording of the current owner thread, this class does so anyway to make usage easier to monitor. It also supports conditions and exposes one of the instrumentation methods:

```java
 class Mutex implements Lock, java.io.Serializable {

   // Our internal helper class
   private static class Sync extends AbstractQueuedSynchronizer {
     // Reports whether in locked state
     protected boolean isHeldExclusively() {
       return getState() == 1;
     }

     // Acquires the lock if state is zero
     public boolean tryAcquire(int acquires) {
       assert acquires == 1; // Otherwise unused
       if (compareAndSetState(0, 1)) {
         setExclusiveOwnerThread(Thread.currentThread());
         return true;
       }
       return false;
     }

     // Releases the lock by setting state to zero
     protected boolean tryRelease(int releases) {
       assert releases == 1; // Otherwise unused
       if (getState() == 0) throw new IllegalMonitorStateException();
       setExclusiveOwnerThread(null);
       setState(0);
       return true;
     }

     // Provides a Condition
     Condition newCondition() { return new ConditionObject(); }

     // Deserializes properly
     private void readObject(ObjectInputStream s)
         throws IOException, ClassNotFoundException {
       s.defaultReadObject();
       setState(0); // reset to unlocked state
     }
   }

   // The sync object does all the hard work. We just forward to it.
   private final Sync sync = new Sync();

   public void lock()                { sync.acquire(1); }
   public boolean tryLock()          { return sync.tryAcquire(1); }
   public void unlock()              { sync.release(1); }
   public Condition newCondition()   { return sync.newCondition(); }
   public boolean isLocked()         { return sync.isHeldExclusively(); }
   public boolean hasQueuedThreads() { return sync.hasQueuedThreads(); }
   public void lockInterruptibly() throws InterruptedException {
     sync.acquireInterruptibly(1);
   }
   public boolean tryLock(long timeout, TimeUnit unit)
       throws InterruptedException {
     return sync.tryAcquireNanos(1, unit.toNanos(timeout));
   }
 }
```

Here is a latch class that is like a [`CountDownLatch`](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/CountDownLatch.html) except that it only requires a single `signal` to fire. Because a latch is non-exclusive, it uses the `shared` acquire and release methods.

```java
 class BooleanLatch {

   private static class Sync extends AbstractQueuedSynchronizer {
     boolean isSignalled() { return getState() != 0; }

     protected int tryAcquireShared(int ignore) {
       return isSignalled() ? 1 : -1;
     }

     protected boolean tryReleaseShared(int ignore) {
       setState(1);
       return true;
     }
   }

   private final Sync sync = new Sync();
   public boolean isSignalled() { return sync.isSignalled(); }
   public void signal()         { sync.releaseShared(1); }
   public void await() throws InterruptedException {
     sync.acquireSharedInterruptibly(1);
   }
 }
```





https://blog.csdn.net/u012152619/article/details/74977570
并发控制的核心是锁的获取与释放，锁的实现方式有很多种，
AQS采用的是一种改进的CLH锁。

CLH(Craig, Landin, andHagersten locks)是一钟自旋锁，
能确保无饥饿性，提供先来先服务的公平性。


####并发包的实现的基础或者叫做根基是什么？

AQS定义了一套多线程访问共享资源的同步器框架，
是整个java.util.concurrent包的基石，
Lock、ReadWriteLock、CountDowndLatch、CyclicBarrier、
Semaphore、ThreadPoolExecutor等都是在AQS的基础上实现的

当然了对于那些AtomticXXX类型的数据类型而言他们是谁建立在CAS的基础上的。

#### AQS的数据模型是什么

AQS维护了一个volatile int state（代表共享资源）
和一个FIFO线程等待队列（多线程争用资源被阻塞时会进入此队列）。



#### AQS同步状态的获取和释放

