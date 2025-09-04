package com.gateway.filters;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class AuthFilterGatewayFilterFactory extends AbstractGatewayFilterFactory<AuthFilterGatewayFilterFactory.Config> {

    private final JwtFilterService jwtFilterService ;

    public AuthFilterGatewayFilterFactory(JwtFilterService jwtFilterService) {
        super(Config.class);
        this.jwtFilterService = jwtFilterService;
    }

    @Override
    public GatewayFilter apply(Config config) {

        return (exchange, chain) -> {

           if (exchange.getRequest().getMethod() == HttpMethod.GET
                    && (exchange.getRequest().getURI().getPath().startsWith("/public"))) {
                return chain.filter(exchange);
            }

            if (exchange.getRequest().getMethod() == HttpMethod.POST
                    && (exchange.getRequest().getURI().getPath().startsWith("/public"))) {
                return chain.filter(exchange);
            }

            String authHeader = exchange.getRequest()
                    .getHeaders()
                    .getFirst("Authorization");

            if (authHeader == null) {
                exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                return exchange.getResponse().setComplete();
            }

            String token = authHeader.split("Bearer ")[1];
            String userId = jwtFilterService.getUserIdFromToken(token);

            exchange.getRequest()
                    .mutate()
                    .header("X-User-Id", userId)
                    .build();

            return chain.filter(exchange);
        };
    }

    public static class Config {
    }
}
