package lshh.appwithinfraexample.infrastructure;

import lshh.appwithinfraexample.service.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponJpaRepository extends JpaRepository<Coupon, Long> {
}
