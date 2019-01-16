/**
 * 
 */
package com.opensource.dada.reactive;

import reactor.core.publisher.Mono;

/**
 * @author dapatil
 *
 */
public interface LinkRepository {

	Mono<Link> save(Link link);
	
	Mono<Link> findByKey(String key);
}
