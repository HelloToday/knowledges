## redis的荣在策略

基本的redis的容灾策略为：

1.  采用master-slave方式

2.  为了得到好的读写性能，master不做任何的持久化

3.  slave同时开启Snapshot和AOF来进行持久化，保证数据的安全性

4.  当master挂掉后，修改slave为master

5.  恢复原master数据，修改原先master为slave，启动slave

6. 若master与slave都挂掉后，调用命令通过aof和snapshot进行恢复

## Redis容灾部署（哨兵Sentinel）
哨兵的作用
1. 监控：监控主从是否正常
2. 通知：出现问题时，可以通知相关人员
3. 故障迁移：自动主从切换
4. 统一的配置管理：连接者询问sentinel取得主从的地址
