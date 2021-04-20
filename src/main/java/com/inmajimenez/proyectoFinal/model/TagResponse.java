package com.inmajimenez.proyectoFinal.model;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class TagResponse {

    private String message;

    private HttpStatus response;

    public TagResponse() {
    }

    public TagResponse(String message, HttpStatus response) {
        this.message = message;
        this.response = response;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getResponse() {
        return response;
    }

    public void setResponse(HttpStatus response) {
        this.response = response;
    }
}

