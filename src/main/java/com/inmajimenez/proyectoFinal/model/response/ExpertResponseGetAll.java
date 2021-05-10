package com.inmajimenez.proyectoFinal.model.response;

import com.inmajimenez.proyectoFinal.model.entities.Expert;

import java.util.List;

public class ExpertResponseGetAll {
    private Long totalCount;

    private List<Expert> experts;

    private Response response;

    public ExpertResponseGetAll() {
    }

    public ExpertResponseGetAll(Long totalCount, List<Expert> experts, Response response) {
        this.totalCount = totalCount;
        this.experts = experts;
        this.response = response;
    }

    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }

    public List<Expert> getExperts() {
        return experts;
    }

    public void setExperts(List<Expert> experts) {
        this.experts = experts;
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    @Override
    public String toString() {
        return "ExpertResponseGetAll{" +
                "totalCount=" + totalCount +
                ", experts=" + experts +
                ", response=" + response +
                '}';
    }
}
