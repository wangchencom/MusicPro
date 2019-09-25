package com.bfh.config;

import com.bfh.utils.RedisObjectSerializer;
import com.bfh.vo.MusicTopVo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.util.List;

/**
 * @Author wcc
 * @Date 2018/2/22.
 * @Description RedisConfig
 */
@Configuration
public class RedisConfig {

//    @Bean
//    JedisConnectionFactory jedisConnectionFactory() {
//        return new JedisConnectionFactory();
//    }

    /**
     * ValueOperations：简单K-V操作
     * SetOperations：set类型数据操作
     * ZSetOperations：zset类型数据操作
     * HashOperations：针对map类型的数据操作
     * ListOperations：针对list类型的数据操作
     */
    @Bean
    public RedisTemplate<String, List<MusicTopVo>> redisTemplate(RedisConnectionFactory factory) {

        RedisTemplate<String, List<MusicTopVo>> template = new RedisTemplate<>();
        template.setConnectionFactory(factory);
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new RedisObjectSerializer());
        return template;

    }
}
