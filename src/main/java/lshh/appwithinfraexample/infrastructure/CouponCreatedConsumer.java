package lshh.appwithinfraexample.infrastructure;

import lombok.RequiredArgsConstructor;
import lshh.appwithinfraexample.service.Coupon;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CouponCreatedConsumer {
    private final CouponRepository couponRepository;

    @KafkaListener(topics = "coupon_create", groupId = "coupon")
    public void listener(Long userId) {
        System.out.println("Coupon created for user: " + userId);
        couponRepository.save(new Coupon(userId));
    }
}
