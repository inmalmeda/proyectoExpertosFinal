package com.inmajimenez.proyectoFinal.model.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.inmajimenez.proyectoFinal.model.entities.Expert;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tags")
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("Clave primaria tipo Long")
    private Long id;

    @ApiModelProperty("Nombre de la etiqueta")
    private String name;

    @ApiModelProperty("Nombre del creador de la etiqueta")
    private String creator;

    @ApiModelProperty("Fecha de creación de la etiqueta")
    private LocalDate created_at;

    @ApiModelProperty("Fecha de modificación de la etiqueta")
    private LocalDate updated_at;

    @JsonIgnore
    @ManyToMany(mappedBy = "tags",fetch = FetchType.LAZY)
    private List<Expert> experts = new ArrayList<>();

    public Tag() {
    }

    public Tag(Long id, String name, String creator, LocalDate created_at, LocalDate updated_at, List<Expert> experts) {
        this.id = id;
        this.name = name;
        this.creator = creator;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.experts = experts;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDate created_at) {
        this.created_at = created_at;
    }

    public LocalDate getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDate updated_at) {
        this.updated_at = updated_at;
    }

    public List<Expert> getExperts() {
        return experts;
    }

    public void setExperts(List<Expert> experts) {
        this.experts = experts;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", creator='" + creator + '\'' +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                '}';
    }
}
