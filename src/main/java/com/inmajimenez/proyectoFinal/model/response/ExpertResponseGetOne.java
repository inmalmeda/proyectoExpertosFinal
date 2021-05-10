package com.inmajimenez.proyectoFinal.model.response;

import com.inmajimenez.proyectoFinal.model.entities.Expert;

public class ExpertResponseGetOne {

    private Expert expert;

    private Response response;

    public ExpertResponseGetOne() {
    }

    public ExpertResponseGetOne(Expert expert, Response response) {
        this.expert = expert;
        this.response = response;
    }

    public Expert getExpert() {
        return expert;
    }

    public void setExpert(Expert expert) {
        this.expert = expert;
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    @Override
    public String toString() {
        return "ExpertResponseGetOne{" +
                "expert=" + expert +
                ", response=" + response +
                '}';
    }
}
