package com.inmajimenez.proyectoFinal.model;

import com.inmajimenez.proyectoFinal.model.entities.Tag;

import java.util.List;

public class TagResponseGetAll {

    private Long totalCount;

    private List<Tag> tags;

    private TagResponse response;

    public TagResponseGetAll() {

    }

    public TagResponseGetAll(Long totalCount, List<Tag> tags, TagResponse response) {
        this.totalCount = totalCount;
        this.tags = tags;
        this.response = response;
    }


    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public TagResponse getResponse() {
        return response;
    }

    public void setResponse(TagResponse response) {
        this.response = response;
    }
}
