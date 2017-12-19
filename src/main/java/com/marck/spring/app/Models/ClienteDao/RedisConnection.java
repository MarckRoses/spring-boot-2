package com.marck.spring.app.Models.ClienteDao;

import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnection;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import com.marck.spring.app.Models.Entity.Cliente;

public class RedisConnection {
	@Bean
	JedisConnectionFactory jedisConnection() {
		return new JedisConnectionFactory();
	}
	@Bean
	RedisTemplate<String,Cliente> redisTemplate(){
		RedisTemplate<String,Cliente> redisTemplate= new RedisTemplate<String,Cliente>();
		redisTemplate.setConnectionFactory(jedisConnection());
		return redisTemplate;
	}
}
