package com.vvs.javajsoupapp.service;

import java.util.List;

import reactor.core.publisher.Mono;

public interface ParserService {

  public Mono<List<String>> parser(String link);
}
