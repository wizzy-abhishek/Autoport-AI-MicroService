package com.user_cart.USER_CART_MS.advices;

import com.user_cart.USER_CART_MS.exception.UnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<APIError> handleUnauthorizedException(UnauthorizedException unauthorizedException){
        APIError response =  APIError
                .builder()
                .message(unauthorizedException.getMessage())
                .success(true)
                .status(HttpStatus.UNAUTHORIZED)
                .build();

        return new ResponseEntity<>(response , HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<APIError> handleResponseException(RuntimeException runtimeException){
        APIError response =  APIError
                .builder()
                .message(runtimeException.getMessage())
                .success(true)
                .status(HttpStatus.I_AM_A_TEAPOT)
                .build();

        return new ResponseEntity<>(response , HttpStatus.I_AM_A_TEAPOT);
    }


}
