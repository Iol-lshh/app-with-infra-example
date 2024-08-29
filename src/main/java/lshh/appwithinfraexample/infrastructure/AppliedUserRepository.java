package lshh.appwithinfraexample.infrastructure;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class AppliedUserRepository {
    private final RedisTemplate<String, String> redisTemplate;

    public Long add(String userId){
        return redisTemplate
                .opsForSet()
                .add("applied_user", userId);
    }

    public void resetAppliedUser(){
        redisTemplate.delete("applied_user");
    }
}
