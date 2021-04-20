package com.inmajimenez.proyectoFinal.dao;

import com.inmajimenez.proyectoFinal.model.TagResponseGetAll;
import com.inmajimenez.proyectoFinal.model.entities.Tag;
import com.inmajimenez.proyectoFinal.model.TagFilters;

import java.util.List;

/**
 * Class DAO for tags
 */
public interface TagDAO {

    /**
     * It returns a list of tags
     * @return Response with of tags
     */
    TagResponseGetAll findAllTags(TagFilters tagFilters);

    /**
     * It returns a tag depending of id
     * @param id Long id of tag
     * @return A tag
     */
    Tag findOneTag(Long id);

}
