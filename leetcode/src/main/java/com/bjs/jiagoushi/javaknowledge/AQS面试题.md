### AbstractQueuedSynchronizer（AQS）

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
