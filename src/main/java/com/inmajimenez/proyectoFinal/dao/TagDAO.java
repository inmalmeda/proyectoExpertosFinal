package com.inmajimenez.proyectoFinal.dao;

import com.inmajimenez.proyectoFinal.model.response.TagResponseGetAll;
import com.inmajimenez.proyectoFinal.model.entities.Tag;
import com.inmajimenez.proyectoFinal.model.request.TagFilters;

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

    /**
     * It deletes the relation with expert in tags in table expert_tag
     * @param id of tag
     * @return true or false
     */
    Boolean deleteRelationWithExperts(Long id);

}
