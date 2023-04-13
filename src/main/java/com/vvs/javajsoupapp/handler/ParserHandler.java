package com.vvs.javajsoupapp.handler;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.vvs.javajsoupapp.service.ParserService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class ParserHandler {

  private final ParserService parserService;

  public Mono<ServerResponse> parser(ServerRequest request) {
    return Mono.just(request.queryParam("url").orElseThrow())
      .flatMap(parserService::parser)
      .flatMap(content -> ServerResponse
        .ok()
        .contentType(MediaType.APPLICATION_JSON)
        .bodyValue(content));
  }
}
