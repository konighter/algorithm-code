- 特性:ACID
  - 持久&原子
    - redo log:
    - undo log:
  - 隔离级别: lock实现
    - read commit: record lock
    - repeated read: MVCC & next key lock
    - serialiable read: 每个查询都默认加 in share mode, 只支持一致性锁定读, 不支持非锁定读;
  
