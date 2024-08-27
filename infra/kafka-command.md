```shell
# 토픽 생성
docker exec -it kafka kafka-topics.sh --bootstrap-server localhost:9092 --create --topic testTopic

# 프로듀서 생성
docker exec -it kafka kafka-console-producer.sh --topic testTopic --broker-list 0.0.0.0:9092

# 컨슈머 생성
docker exec -it kafka kafka-console-consumer.sh --topic testTopic --bootstrap-server localhost:9092
```

```shell
# 토픽 생성
docker exec -it kafka kafka-topics.sh --bootstrap-server localhost:9092 --create --topic coupon_create

# 컨슈머 생성
docker exec -it kafka kafka-console-consumer.sh --topic coupon_create --bootstrap-server localhost:9092 --key-deserializer "org.apache.kafka.common.serialization.StringDeserializer" --value-deserializer "org.apache.kafka.common.serialization.LongDeserializer"
```

