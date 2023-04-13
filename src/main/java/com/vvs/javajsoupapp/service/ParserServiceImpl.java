package com.vvs.javajsoupapp.service;

import java.io.IOException;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Mono;

@Service
public class ParserServiceImpl implements ParserService {

  @Override
  public Mono<List<String>> parser(String url) {
    return Mono.fromSupplier(() -> {
      try {
        Document doc = Jsoup.connect(url).get();
        return doc;
      } catch (IOException e) {
        throw new RuntimeException(e.getMessage());
      }
    })
    .map(document -> document.select(".title"))
    .flatMapIterable(elements -> elements)
    .map(element -> element.text())
    .collectList();
  }

}
