package lshh.appwithinfraexample.infrastructure;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CouponCreatedProducer {
    private final KafkaTemplate<String, Long> kafkaTemplate;

    public void create(Long userId){
        kafkaTemplate.send("coupon_create", userId);

    }
}
