package com.fiap.backend.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestJwt {
    private String email;
    private String password;
}
