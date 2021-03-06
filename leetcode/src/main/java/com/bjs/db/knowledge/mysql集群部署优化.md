    max_connections = 151
    #同时处理最大连接数，推荐设置最大连接数是上限连接数的80%左右
    
     sort_buffer_size = 2M
    
    #查询排序时缓冲区大小，只对order by和group by起作用，可增大此值为16M
    
      query_cache_limit = 1M
    
      #查询缓存限制，只有1M以下查询结果才会被缓存，以免结果数据较大把缓存池覆盖
    
      query_cache_size = 16M
    
      #查看缓冲区大小，用于缓存SELECT查询结果，下一次有同样SELECT查询将直接从缓存池返回结果，可适当成倍增加此值
    
      open_files_limit = 1024
    
      #打开文件数限制，如果show global status like 'open_files'查看的值等于或者大于open_files_limit值时，程序会无法连接数据库或卡死



#### 忽然想到一个问题，mysql读写分离或者说mysql集群是如何和spring集成的？


#### 虽然我没有去听课但是我知道mysql所谓的集群高可用 负载均衡等等都是建立在复制的基础上的？

所以mysql由于内在的这种复制机制是存在一定的网络延迟的，所以一个时间点上
可能存在主库和备库之间的数据不一致的问题的。

#### mysql复制解决的是什么问题？

* 数据分布

``通常情况下呢，不会给带宽带来很大的压力但是5.1引入的基于行的复制会带来更大的带宽压力
所以尽量的选择一些低延迟的连接``

* 负载均衡

``将数据存储在多个服务器上达到对于读密集型的应用的优化``

* 备份

``备份的补充，但是他不可以取代备份``

* 高可用和故障切换

* mysql的升级测试



#### 复制的工作原理

概述：这个问题就像是把大象放在冰箱里拢共分几步的问题：主库把数据更改记录到二进制文件里面，备库讲日志复制到自己的中继日志里面，备库读取日志重放

1.  基于语句的的复制

   * 优点：

     实现简单，数据紧凑缺点：

   * 缺点

     * 数据库上的的语句执行除了语句之外还依赖其他的因素 诸如时间戳等等
     * 更新必须是串行的，需要更多地锁
     * 并不是所有的引擎都支持

2. 基于行的复制

   * 优点：可以正确地复制每一行
   * 缺点：兼容性



   **幸运的是mysql会自己的动态的切换这两种模式**







   ### 复制的拓扑结构

   牢记以下几个知识点：

   * 一个备库只能有一个主库
   * 每个备库必须有一个唯一的服务器ID
   * 一个主库可以有多个备库
   * 如果打开了log_slave_updates选项 一个备库可以把其他的主库数据变化更新同步到其他的备库。



   #### 复制和容量规划



   * 知识补充：我之前也是像书里面说得那样认为增加一台服务器就可以增加一倍的查询速度和支撑速度但是文章告诉我们，这样想是幼稚的，因为这一台服务器还有一部分的容量是浪费在了对于和主库的数据同步上面的。比如单台机器1000 的查询 读写比例是20%--80%，也就是说200的写操作 800的读操作 。如果想要提高一倍的查询，需要多好机器支撑？

     思路是这样的增加一台机器的时候 2000  --》400+1600

     也就说说每台从服务器400的写入 所以只有 600的查询，所以需要三台服务器支撑。





   ## 分片or 不分片

   * 主备模式只能扩展读的容量，无法扩展写的容量 甚至会拉低写的效率因为会有主从复制这个机制的存在

   对应的是高级mysql的是10--11章节

     

   ​	