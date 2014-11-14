# prepare test data
sysbench --test=oltp --oltp-table-size=100000 --mysql-db=performance --mysql-user=root --mysql-password=1234 prepare

# run test
sysbench --test=oltp --oltp-table-size=100000 --mysql-db=performance --mysql-user=root --mysql-password=1234 --max-time=60 --oltp-read-only=on --max-requests=0 --num-threads=8 run