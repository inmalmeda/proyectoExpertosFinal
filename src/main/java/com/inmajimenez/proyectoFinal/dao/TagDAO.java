package com.inmajimenez.proyectoFinal.dao;

import com.inmajimenez.proyectoFinal.model.Tag;

import java.util.List;

/**
 * Class DAO for tags
 */
public interface TagDAO {

    /**
     * It returns a list of tags
     * @return List of tags
     */
    List<Tag> findAllTags();

    /**
     * It returns a tag depending of id
     * @param id Long id of tag
     * @return A tag
     */
    Tag findOneTag(Long id);

}
