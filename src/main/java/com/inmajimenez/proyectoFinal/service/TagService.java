package com.inmajimenez.proyectoFinal.service;

import com.inmajimenez.proyectoFinal.model.entities.Tag;
import com.inmajimenez.proyectoFinal.model.TagFilters;

import java.util.List;

/**
 * Class service for tags
 */
public interface TagService {

    /**
     * It returns a list of tags
     * @param filters Filters to look for tags
     * @return List of tags
     */
    List<Tag> findAllTags(TagFilters filters);

    /**
     * It returns a tag depending of id
     * @param id Long id of tag
     * @return A tag
     */
    Tag findOneTagById(Long id);

    /**
     * It saves a tag
     * @param tag New tag
     * @return The tag created
     */
    Tag createTag(Tag tag);

    /**
     * It updates a tag
     * @param tag The tag
     * @return The tag updated
     */
    Tag updateTag(Tag tag);

    /**
     * It deletes one tag by id
     * @param id id of tag
     * @return true or false
     */
    boolean deleteTagById(Long id);
}
