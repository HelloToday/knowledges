1. redis的数据类型有哪些？

答： String,hash,list,set,zset(有序的集合)

* redis String 常见的应用场景我在各个公司看到的都是存储一些对象json之后的对象

* redis Hash的应用场景

    答：redis hash呢特别适合存储对象，所以考虑先把对象转成Map然后存储到redis里面
    
    还有一个典型的应用场景就是购物车。
    
    解答我很早的一个疑惑：她和string有什么区别优劣？
    它的添加、删除操作都是 O(1)（平均操作)
    hash 特别 适合用于存储对象。相较于将对象的每个字段存成单个 string 类型（string 类型可以存储对象序列化）。 
    将一个对象存储在 hash 类型中会占用更少的内存，并且可以更方便的存取整个对象。
        
    (省内存的原因是新建一个 hash 对象时开始是用 zipmap（又称为 small hash）来存储的。 
    这个 zipmap 其实并不是 hash table，但是 zipmap 相比正常的 hash 
    实现可以节省不少 hash 本身需要的一些元数据存储开销。
    
    使用场景见下面这篇文章
    
    https://blog.csdn.net/ahjxhy2010/article/details/79892894
    
    https://blog.csdn.net/xiaoliuliu2050/article/details/73250708
    
    上面已经说到Redis Hash对应Value内部实际就是一个HashMap，
    实际这里会有2种不同实现，
    这个Hash的成员比较少时Redis为了节省内存会采用类似一维数组的方式来紧凑存储，
    而不会采用真正的HashMap结构，
    对应的value redisObject的encoding为zipmap,
    当成员数量增大时会自动转成真正的HashMap,此时encoding为ht。
    
* redis list应用场景？

答：最新消息的排行、消息队列
 实现方式：  
    Redis list的实现为一个双向链表，即可以支持反向查找和遍历，更方便操作，
    不过带来了部分额外的内存开销，Redis内部的很多实现，
    包括发送缓冲队列等也都是用的这个数据结构。  
    

* Set的应用场景？

答案：Redis set对外提供的功能与list类似是一个列表的功能，
特殊之处在于set是可以自动**去重**的，当你需要存储一个列表数据，又不希望出现重复数据时，
set是一个很好的选择，并且set提供了判断某个成员是否在一个set集合内的重要接口，
这个也是list所不能提供的。  
比如在微博应用中，每个人的好友存在一个集合（set）中，这样求两个人的共同好友的操作，
可能就只需要用求交集命令即可。  
Redis还为集合提供了求交集、并集、差集等操作，可以非常方便的实线上面两个功能。

我想到了另外一个功能：那就是共同关注，共同好友，共同阅读等等功能
  
实现方式：  
set 的内部实现是一个 value永远为null的HashMap，实际就是通过计算hash的方式来快速排重的，这也是set能提供判断一个成员是否在集合内的原因。  


* sorted set的应用场景

排序功能。时间线功能。分数排序。
