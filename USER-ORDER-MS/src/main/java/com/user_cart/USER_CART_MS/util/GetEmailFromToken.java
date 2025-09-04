package com.user_cart.USER_CART_MS.util;

import com.user_cart.USER_CART_MS.exception.UnauthorizedException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

@Component
public class GetEmailFromToken {

    private final JwtUtil jwtUtil;

    public GetEmailFromToken(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    public String fetchAppUserEmail(HttpServletRequest httpRequest) {
        String appUserEmail = jwtUtil.getUserFromToken(
                ExtractTokenFromRequest.extractTokenFromHeader(httpRequest));
        boolean isUser = (appUserEmail != null && !(appUserEmail.isEmpty()));

        if(isUser) return appUserEmail;
        else throw new UnauthorizedException("No logged in or unauthorized user");
    }
}
