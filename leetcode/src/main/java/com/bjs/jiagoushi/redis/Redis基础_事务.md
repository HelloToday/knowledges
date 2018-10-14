### redis的事务

https://redisbook.readthedocs.io/en/latest/feature/transaction.html

1. 构成

redis的事务功能基础由一下几个命令构成MULTI、EXEC、DISCARD和WATCH

一个事务从开始到执行会经历以下三个阶段：

    开始事务。（MULTI）
    命令入队。
    执行事务。（EXEC）
    
    DISCARD（手动清除命令队列 事务队列）
