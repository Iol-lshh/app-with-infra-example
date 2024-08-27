package lshh.appwithinfraexample.infrastructure;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class CouponCounter {
    private final RedisTemplate<String, String> redisTemplate;

    public Long increaseCouponCount() {
        return redisTemplate
                .opsForValue()
                .increment("coupon_count");
    }

    public void resetCouponCount() {
        redisTemplate.delete("coupon_count");
    }
}
