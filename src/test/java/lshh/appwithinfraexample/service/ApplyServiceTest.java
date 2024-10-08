package lshh.appwithinfraexample.service;

import lshh.appwithinfraexample.infrastructure.AppliedUserRepository;
import lshh.appwithinfraexample.infrastructure.CouponCounter;
import lshh.appwithinfraexample.infrastructure.CouponRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
//@ActiveProfiles("test")
public class ApplyServiceTest {

    @Autowired
    private ApplyService applyService;
    @Autowired
    private CouponRepository couponRepository;
    @Autowired
    private CouponCounter couponCounter;
    @Autowired
    private AppliedUserRepository appliedUserRepository;

    @Test
    public void 쿠폰_여러명_응모() throws InterruptedException {
        couponCounter.resetCouponCount();
        appliedUserRepository.resetAppliedUser();

        int transactionCount = 1000;
        ExecutorService executorService = Executors.newFixedThreadPool(32);
        CountDownLatch latch = new CountDownLatch(transactionCount);
        for (int i = 0; i < transactionCount; i++) {
            long userId = i;
            executorService.submit(() -> {
                try{
                    applyService.apply(userId);
                }finally {
                    latch.countDown();
                }
            });
        }
        latch.await();

        long count = couponRepository.count();
        assertEquals(100, count);

    }


}