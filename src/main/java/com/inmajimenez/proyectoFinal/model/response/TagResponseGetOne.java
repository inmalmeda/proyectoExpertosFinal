package com.inmajimenez.proyectoFinal.model.response;

import com.inmajimenez.proyectoFinal.model.entities.Tag;
import com.inmajimenez.proyectoFinal.model.response.Response;

public class TagResponseGetOne {

    private Tag tag;

    private Response response;

    public TagResponseGetOne() {
    }

    public TagResponseGetOne(Tag tag, Response response) {
        this.tag = tag;
        this.response = response;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    @Override
    public String toString() {
        return "TagResponseGetOne{" +
                "tag=" + tag +
                ", response=" + response +
                '}';
    }
}
