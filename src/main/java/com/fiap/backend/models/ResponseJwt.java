package com.fiap.backend.models;


public class ResponseJwt {
    private final String jwt;

    public ResponseJwt(String jwt) {
        this.jwt = jwt;
    }

    public String getJwt() {
        return jwt;
    }
}
