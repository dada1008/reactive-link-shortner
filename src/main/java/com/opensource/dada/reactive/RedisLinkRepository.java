/**
 * 
 */
package com.opensource.dada.reactive;

import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.stereotype.Repository;

import reactor.core.publisher.Mono;

/**
 * @author dapatil
 *
 */
@Repository
public class RedisLinkRepository implements LinkRepository {

	private ReactiveRedisOperations<String, String> operations;
	
	public RedisLinkRepository(ReactiveRedisOperations<String, String> operations) {
		this.operations = operations;
	}
	
	@Override
	public Mono<Link> save(Link link) {
		return operations.opsForValue().set(link.getKey(), link.getOriginalLink()).map(__ -> link);
	}

	public Mono<Link> findByKey(String key) {
		return operations.opsForValue().get(key).map(result -> new Link(result, key));
	}

}
