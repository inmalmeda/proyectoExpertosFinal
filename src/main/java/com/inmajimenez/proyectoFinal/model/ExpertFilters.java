package com.inmajimenez.proyectoFinal.model;

public class ExpertFilters {

    private String name;
    private String mode;
    private String state;
    private Integer score;
    private String tag;
    private String page;
    private String limit;


    public ExpertFilters(String name, String mode, String state, Integer score, String tag, String page, String limit) {
        this.name = name;
        this.mode = mode;
        this.state = state;
        this.score = score;
        this.tag = tag;
        this.page = page;
        this.limit = limit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getLimit() {
        return limit;
    }

    public void setLimit(String limit) {
        this.limit = limit;
    }

    @Override
    public String toString() {
        return "ExpertFilters{" +
                "name='" + name + '\'' +
                ", mode='" + mode + '\'' +
                ", state='" + state + '\'' +
                ", score=" + score +
                ", tag='" + tag + '\'' +
                ", page='" + page + '\'' +
                ", limit='" + limit + '\'' +
                '}';
    }
}
