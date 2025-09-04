package com.user_cart.USER_CART_MS.advices;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class APIError {

    private String message ;
    private boolean success ;
    private HttpStatus status ;

}
