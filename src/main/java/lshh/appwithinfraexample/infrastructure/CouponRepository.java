package lshh.appwithinfraexample.infrastructure;

import lombok.RequiredArgsConstructor;
import lshh.appwithinfraexample.service.Coupon;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class CouponRepository {
    private final CouponJpaRepository jpaRepository;

    public void save(Coupon coupon) {
        jpaRepository.save(coupon);
    }

    public long count() {
        return jpaRepository.count();
    }
}
