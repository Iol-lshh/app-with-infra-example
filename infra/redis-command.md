
```shell
docker exec -it redis redis-cli

# 전체 지우기
flushall

# set 만들기 sadd <key> <value>
sadd coupon_list "coupon1"
```
- 레디스는 싱글 스레드
- `incr coupon_count`
  - 1씩 증가

