package lshh.appwithinfraexample.service;

import lombok.RequiredArgsConstructor;
import lshh.appwithinfraexample.infrastructure.CouponCounter;
import lshh.appwithinfraexample.infrastructure.CouponCreatedProducer;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ApplyService {
    private final CouponCounter couponCounter;
    private final CouponCreatedProducer couponCreatedProducer;

    public void apply(Long userId) {
        Long count = couponCounter.increaseCouponCount();
        if(count>100){
            return;
        }
        couponCreatedProducer.create(userId);

    }
}
