package com.finelite.blog.web.config.redis;

import com.alibaba.fastjson.parser.ParserConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class RedisConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(RedisConfig.class);

    @Autowired
    private RedisConfigProperties redis;

    public RedisSerializer fastJson2JsonRedisSerializer(){

        ParserConfig.getGlobalInstance().setAutoTypeSupport(true);

        LOGGER.info("------fastJson2JsonRedisSerializer-----");

        return new FastJson2JsonRedisSerializer<Object>(Object.class);
    }

    @Bean
    public RedisConnectionFactory redisConnectionFactory() {

        LOGGER.info("---------redisConnectionFactory : " + redis.toString());

        try {

            RedisStandaloneConfiguration rf = new RedisStandaloneConfiguration();
            rf.setDatabase(redis.getDatabase());
            rf.setHostName(redis.getHost());
            rf.setPort(redis.getPort());

            JedisClientConfiguration.JedisPoolingClientConfigurationBuilder jpb =
                    (JedisClientConfiguration.JedisPoolingClientConfigurationBuilder) JedisClientConfiguration.builder();

            JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
            //最大空闲接连
            jedisPoolConfig.setMaxIdle(redis.getMaxIdle());
            //最小空闲连接
            jedisPoolConfig.setMinIdle(redis.getMinIdle());
            //连接池最大阻塞等待时间
            jedisPoolConfig.setMaxWaitMillis(redis.getMaxWait());

            jpb.poolConfig(jedisPoolConfig);

            JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory(rf, jpb.build());

            return jedisConnectionFactory;
        }catch (Exception e){
            e.printStackTrace();

        }

        return  null;

    }

    @Bean
    public RedisTemplate<String, String> redisTemplate(
            RedisConnectionFactory factory, RedisSerializer fastJson2JsonRedisSerializer) {

            try {

                StringRedisTemplate redisTemplate = new StringRedisTemplate(factory);

                redisTemplate.setConnectionFactory(redisConnectionFactory());
                //redis   开启事务
                redisTemplate.setEnableTransactionSupport(true);
                //hash  使用jdk  的序列化
                redisTemplate.setHashValueSerializer(fastJson2JsonRedisSerializer);
                //StringRedisSerializer  key  序列化
                redisTemplate.setHashKeySerializer(new StringRedisSerializer());
                //keySerializer  对key的默认序列化器。默认值是StringSerializer
                redisTemplate.setKeySerializer(new StringRedisSerializer());
                //  valueSerializer
                redisTemplate.setValueSerializer(fastJson2JsonRedisSerializer);
                redisTemplate.afterPropertiesSet();

                LOGGER.info("------redisTemplate-----");
                return redisTemplate;
            }catch (Exception e){
                e.printStackTrace();
            }

            return null;

    }

}
