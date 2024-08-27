package lshh.appwithinfraexample.service;

import lombok.RequiredArgsConstructor;
import lshh.appwithinfraexample.infrastructure.AppliedUserRepository;
import lshh.appwithinfraexample.infrastructure.CouponCounter;
import lshh.appwithinfraexample.infrastructure.CouponCreatedProducer;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ApplyService {
    private final CouponCounter couponCounter;
    private final CouponCreatedProducer couponCreatedProducer;
    private final AppliedUserRepository appliedUserRepository;

    public void apply(Long userId) {
        Long tryApply = appliedUserRepository.add(userId.toString());
        if(tryApply != 1){
            return;
        }
        Long count = couponCounter.increaseCouponCount();
        if(count>100){
            return;
        }
        couponCreatedProducer.create(userId);

    }
}
