package com.inmajimenez.proyectoFinal.model;

import com.inmajimenez.proyectoFinal.model.entities.User;


public class ResponseLoggin {

    private String nameUser;

    private String emailUser;

    private Response response;

    public ResponseLoggin() {
    }

    public ResponseLoggin(String nameUser, String emailUser, String token, Response response) {
        this.nameUser = nameUser;
        this.emailUser = emailUser;
        this.response = response;
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

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }
}
