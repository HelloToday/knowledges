## xml配置mybatis

1. mybatis读取配置文件的顺序

- 在 properties 元素体内指定的属性首先被读取。 
  然后根据 properties 元素中的 resource 属性读取类路径下属性文件或根据 url 属性指定的路径读取属性文件，并覆盖已读取的同名属性。 
  最后读取作为方法参数传递的属性，并覆盖已读取的同名属性。 
  因此，通过方法参数传递的属性具有最高优先级，resource/url 属性中指定的配置文件次之，最低优先级的是 properties 属性中指定的属性。
  

## 想到一个问题记录下来
分布式的数据库的事务是怎么处理的？

## Mapper文件的讲解

    字符串替换 
    默认情况下,使用 #{} 格式的语法会导致 MyBatis 创建 PreparedStatement 参数并安全地设置参数
    （就像使用 ? 一样）。这样做更安全，更迅速，通常也是首选做法，不过有时你就是想直接在 SQL 语句中
    插入一个不转义的字符串。比如，像 ORDER BY，你可以这样来使用：

## ResultMap
这个对象用来解决数据库当中的列名属性和pojo里面的属性不一致的问题；

- 这个属性可以支持特别高级晦涩得的查询机制 但是不建议使用 他需要有强大的单元测试类支持
否则很难一次成功的写出一个完美正确SQL MAP

## Mybatis的缓存机制

默认情况下是没有开启缓存的,除了局部的 session 缓存,可以增强变现而且处理循环 依赖也是必须的。

    映射语句文件中的所有 select 语句将会被缓存。
    映射语句文件中的所有 insert,update 和 delete 语句会刷新缓存。
    缓存会使用 Least Recently Used(LRU,最近最少使用的)算法来收回。
    根据时间表(比如 no Flush Interval,没有刷新间隔), 缓存不会以任何时间顺序 来刷新。
    缓存会存储列表集合或对象(无论查询方法返回什么)的 1024 个引用。
    缓存会被视为是 read/write(可读/可写)的缓存,意味着对象检索不是共享的,而 且可以安全地被调用者修改,而不干扰其他调用者或线程所做的潜在修改。 


缓存的回收策略

    LRU – 最近最少使用的:移除最长时间不被使用的对象。 
    FIFO – 先进先出:按对象进入缓存的顺序来移除它们。 
    SOFT – 软引用:移除基于垃圾回收器状态和软引用规则的对象。 
    WEAK – 弱引用:更积极地移除基于垃圾收集器状态和弱引用规则的对象。

MyBatis中使用缓存来提高其性能。
MyBatis中的缓存分为两种：一级缓存和二级缓存。使用过MyBatis的可能听到过这样一句话“一级缓存是sqlSession级别的，二级缓存是mapper级别的”。这也说明了，当使用同一个sqlSession时，查询到的数据可能是一级缓存；而当使用同一个mapper是，查询到的数据可能是二级缓存。

``下面是我理解的知识点：所谓的local就是只在一次会话当中有作用，mybatis默认的开启级别就是这个，
但是他有没有问题呢？当然有。比如说同一个sql在不同的sqlsession当中用到了 但是由于他的界别是local的无法在不同的的sqlsession当中共享所以他是没有作用的。
当我们的配置文件配置了cacheEnabled=true时，就会开启二级缓存，二级缓存是mapper级别的，也就说不同的sqlsession使用同一个mapper查询是，查询到的数据可能是另一个sqlsession做相同操作留下的缓存。

而二级缓存的是这样的：SqlSession对象创建Executor对象时，会对Executor对象加上一个装饰者：CachingExecutor，然后将操作数据库的任务交给CachingExecutor，此时CachingExecutor会查找二级缓存是否有需要的数据，如果没有则将任务交给Executor对象。
``

## 动态SQL

- if
- choose, when, otherwise


## 注解

注意 不幸的是，Java 注解的的表达力和灵活性十分有限。尽管很多时间都花在调查、设计和试验上，最强大的 MyBatis 映射并不能用注解来构建——并不是在开玩笑，的确是这样。比方说，C#属性就没有这些限制，因此 MyBatis.NET 将会比 XML 有更丰富的选择。也就是说，基于 Java 注解的配置离不开它的特性。
  

## sql语句构建器



## redis的缓存回收策略是啥？


## 领域模型是什么