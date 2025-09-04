package com.user_cart.USER_CART_MS.util;

import jakarta.servlet.http.HttpServletRequest;

public class ExtractTokenFromRequest {

    public static String extractTokenFromHeader(HttpServletRequest request) {
        String header = request.getHeader("Authorization");
        if (header != null && header.startsWith("Bearer ")) {
            return header.substring(7);
        }
        return null;
    }
}
