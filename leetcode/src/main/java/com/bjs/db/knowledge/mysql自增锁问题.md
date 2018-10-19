https://blog.csdn.net/qiuyepiaoling/article/details/49923703

#### 如果一个mysql表里面有一个自增字段，那么一个事务ta插入一条记录之后未曾提交，这时候事务tb再插入另外一个记录 请问前的事务tb能不能提交？

答：mysql里面有一个自增锁的概念。

* 5.1.22之前InnoDB自增值是通过其本身的自增长计数器来获取值，
该实现方式是通过表锁机制来完成的（AUTO-INC LOCKING），
锁不是在每次事务完成后释放，而是在完成对自增长值插入的SQL语句后释放，
要等待其释放才能进行后续操作。
比如说当表里有一个auto_increment字段的时候，
innoDB会在内存里保存一个计数器用来记录auto_increment的值，
当插入一个新行数据时，就会用一个表锁来锁住这个计数器，
直到插入结束。如果大量的并发插入，表锁会引起SQL堵塞。

* 在5.1.22之后，InnoDB为了解决自增主键锁表的问题，
引入了参数innodb_autoinc_lock_mode，
该实现方式是通过轻量级互斥量的增长机制完成的。
它是专门用来在使用auto_increment的情况下调整锁策略
innodb_autoinc_lock_mode：可以设定3个值，0，1，2

1. traditonal 通过表锁的方式进行,所有类型的insert都用AUTO-inc locking。
2. consecutive 默认值，产生一个轻量锁，对于simple insert 自增长值的产生使用互斥量对内存中的计数器进行累加操作，对于bulk insert 
   则还是使用表锁的方式进行。
3. 对所有的insert-like 自增长值的产生使用互斥量机制完成，
   并发性能最高，并发插入可能导致自增值不连续，
   可能会导致Statement 的 Replication 出现不一致，
   使用该模式，需要用 Row Replication的模式。
   
   
   
#### 关于insert的知识的补充？

* INSERT-LIKE：   指所有的插入语句，比如 INSERT、REPLACE、INSERT…SELECT、REPLACE…SELECT,LOAD DATA等
* Simple inserts：指在插入前就能确定插入行数的语句，包括INSERT、REPLACE，不包含INSERT…ON DUPLICATE KEY UPDATE这类语句。
* Bulk inserts：  指在插入前不能确定得到插入行的语句。如INSERT…SELECT, REPLACE…SELECT, LOAD DATA.
* Mixed-mode inserts:指其中一部分是自增长的，有一部分是确定的。insert t1(id,xx) values(1,11)(null,22)

#### 在自增的字段设置为非传统的时候，存在的问题？
并发性能的支持和最后数据的是不是连续的矛盾






