package com.opensource.dada.reactive;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.stubbing.Answer;

import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

public class LinkServiceTest {

	String testBaseUrl = "http://some-domain.com/";
	private LinkRepository linkRepository = mock(LinkRepository.class);
	private LinkService linkService = new LinkService(testBaseUrl, linkRepository);
	
	@Before
    public void setup() {
        when(linkRepository.save(any()))
                .thenAnswer((Answer<Mono<Link>>) invocationOnMock -> Mono.just((Link) invocationOnMock.getArguments()[0]));
    }
	
	@Test
	public void shortenLink() {
		StepVerifier.create(linkService.shortenLink("https://spring.io"))
		.expectNextMatches(result -> result!=null && !result.isEmpty() && result.startsWith(testBaseUrl))
		.expectComplete().verify()
		;
	}
}
