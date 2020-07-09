package com.mcks.spring.security.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class AuthenticationRequest {
    private String username;

    private String password;
}
