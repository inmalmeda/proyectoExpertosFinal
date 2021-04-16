package com.inmajimenez.proyectoFinal.model;

/**
 * Class with filters of tags
 */
public class TagFilters {

    private String name;
    private String page;
    private String limit;

    public TagFilters(String name, String page, String limit) {
        this.name = name;
        this.page = page;
        this.limit = limit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return "TagFilters{" +
                "name='" + name + '\'' +
                ", page='" + page + '\'' +
                ", limit='" + limit + '\'' +
                '}';
    }
}
