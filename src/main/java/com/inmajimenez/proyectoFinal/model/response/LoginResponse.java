package com.inmajimenez.proyectoFinal.model.response;

import com.inmajimenez.proyectoFinal.model.response.Response;


public class LoginResponse {

    private String nameUser;

    private String emailUser;

    private String token;

    public LoginResponse() {
    }

    public LoginResponse(String nameUser, String emailUser, String token) {
        this.nameUser = nameUser;
        this.emailUser = emailUser;
        this.token = token;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
