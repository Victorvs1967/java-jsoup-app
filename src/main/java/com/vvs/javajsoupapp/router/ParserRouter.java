package com.vvs.javajsoupapp.router;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.vvs.javajsoupapp.handler.ParserHandler;

@Configuration
public class ParserRouter {

  @Bean
  public RouterFunction<ServerResponse> parserRouterFunction(ParserHandler handler) {
      return RouterFunctions.route()
        .nest(RequestPredicates.path("/api/parse"), builder -> builder
          .GET("/", handler::parser))
        .build();
  }
}
