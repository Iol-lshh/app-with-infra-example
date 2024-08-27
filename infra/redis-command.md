
```shell
docker exec -it redis redis-cli

flushall
```
- 레디스는 싱글 스레드
- `incr coupon_count`
  - 1씩 증가

