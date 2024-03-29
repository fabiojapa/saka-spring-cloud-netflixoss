package com.saka.demo.redis.rest.sakaeurekaclientredis;

import com.saka.demo.redis.rest.sakaeurekaclientredis.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@EnableDiscoveryClient
@SpringBootApplication
public class SakaEurekaClientRedisApplication {

	@Value(value = "${redis.hostname}")
	private String redisHostname;

	@Value(value = "${redis.port}")
	private int redisPort;

	public static void main(String[] args) {
		SpringApplication.run(SakaEurekaClientRedisApplication.class, args);
	}

	@Bean
	JedisConnectionFactory jedisConnectionFactory() {
		RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration(redisHostname, redisPort);
		return new JedisConnectionFactory(redisStandaloneConfiguration);
	}

	@Bean
	public RedisTemplate<String, User> userTemplate() {
		RedisTemplate<String, User> template = new RedisTemplate<>();
		template.setConnectionFactory(jedisConnectionFactory());
		template.setKeySerializer(new StringRedisSerializer());
		return template;
	}

}

