package com.gateway.filters;

public interface JwtFilterService {

    String getUserIdFromToken(String token);

}
