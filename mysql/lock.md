## mysql锁

- 类型, 层级-表/页/行
  - 共享锁(S)/排他锁(X): 行锁, S和X不兼容; 
  - 意向共享锁(IS)/意向排他锁(IX): 意向锁是表级别,IS和IX都是兼容的; IX 与 S/X 不兼容; IS 与 X 不兼容;
- 锁定读
  - 一致性非锁定读: 快照读
    - read commit: 最新快照
    - repeated read: 事务快照
  - 一致性锁定读: select for update;  select in share mode;
- 自增长锁
  - auto-inc locking: sql执行完释放锁
  - innodb_auto_lock_mode:
    - 表锁auto_inc locking;
    - simple inserts(确定行) 用mutex; bulk inserts(不确定行数) auto-inc locking;
    - 全部 mutex, 且只在row-base的binlog下可用
- 锁算法
  - record lock: 
  - gap lock; 一般只有外键约束检查会用到.
  - next-key lock; 左开右闭的索引区间. record& gap lock;
  
    
  
  
