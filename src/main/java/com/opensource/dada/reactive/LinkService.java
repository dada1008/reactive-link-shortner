package com.opensource.dada.reactive;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Mono;

@Service
public class LinkService {

	private String baseUrl;
	private LinkRepository linkRepository;
	public LinkService(@Value("${app.baseUrl}") String baseUrl, @Autowired LinkRepository linkRepository) {
		this.baseUrl = baseUrl;
		this.linkRepository = linkRepository;
	}
	
	public Mono<String> shortenLink(String link) {
		String randomKey = RandomStringUtils.randomAlphabetic(6);
		return linkRepository.save(new Link(link, randomKey)).map(result -> baseUrl + result.getKey());
	}
	
	Mono<Link> getOriginalLink(String key) {
        return linkRepository.findByKey(key);
    }
}
