package com.linsir.gateway.config;



import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.linsir.core.mybatis.cache.DictionaryCacheManager;
import com.linsir.core.mybatis.cache.DynamicRedisCacheManager;
import com.linsir.core.mybatis.cache.I18nCacheManager;
import com.linsir.core.mybatis.config.Cons;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.util.HashMap;
import java.util.Map;


/**
 * description：缓存配置
 * author     ：linsir
 * version    ： v1.2.0
 * date       ：2025/2/3 12:42
 */
@Configuration
@Slf4j
public class CashConfiguration {
    @Bean
    @ConditionalOnMissingBean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory connectionFactory) {
        //... 初始化RedisTemplate
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();

        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        // 用StringRedisSerializer 序列化和反序列化key值
        redisTemplate.setKeySerializer(stringRedisSerializer);
        redisTemplate.setHashKeySerializer(stringRedisSerializer);

        // 用Jackson2JsonRedisSerializer 序列化和反序列化value值
        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer());
        redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer());

        redisTemplate.setConnectionFactory(connectionFactory);
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }
    private Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.ALL , JsonAutoDetect.Visibility.ANY);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES , false);
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS , false);
        objectMapper.activateDefaultTyping(objectMapper.getPolymorphicTypeValidator() , ObjectMapper.DefaultTyping.NON_FINAL);
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        objectMapper.registerModule(new JavaTimeModule());

        FilterProvider filterProvider = new SimpleFilterProvider().addFilter("rewrite-bean" , SimpleBeanPropertyFilter.serializeAllExcept("realmNames"));
        objectMapper.setFilterProvider(filterProvider);

        return new Jackson2JsonRedisSerializer<>(objectMapper, Object.class);
    }

    /**
     * 字典等基础数据缓存管理器
     * @return
     */
    @Bean
    @ConditionalOnMissingBean
    public DictionaryCacheManager dictionaryCacheManager(RedisTemplate redisTemplate) {
        log.info("初始化 Dictionary Redis缓存: DynamicRedisCacheManager");
        Map<String, Integer> cacheName2ExpireMap = new HashMap<>() {{
            put(Cons.CACHE_NAME_DICTIONARY, 24*60);
        }};
        DynamicRedisCacheManager redisCacheManager = new DynamicRedisCacheManager(redisTemplate, cacheName2ExpireMap);
        return new DictionaryCacheManager(redisCacheManager);
    }

    /**
     * 国际化等基础数据缓存管理器
     * @return
     */
    @Bean
    @ConditionalOnMissingBean
    public I18nCacheManager i18nCacheManager(RedisTemplate redisTemplate) {
        log.info("初始化 I18n Redis缓存: DynamicRedisCacheManager");
        Map<String, Integer> cacheName2ExpireMap = new HashMap<>() {{
            put(Cons.CACHE_NAME_I18N, 24*60);
        }};
        DynamicRedisCacheManager memoryCacheManager = new DynamicRedisCacheManager(redisTemplate, cacheName2ExpireMap);
        return new I18nCacheManager(memoryCacheManager);
    }


}
