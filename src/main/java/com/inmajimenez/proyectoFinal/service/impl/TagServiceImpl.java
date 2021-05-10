package com.inmajimenez.proyectoFinal.service.impl;

import com.inmajimenez.proyectoFinal.dao.TagDAO;
import com.inmajimenez.proyectoFinal.model.response.TagResponseGetAll;
import com.inmajimenez.proyectoFinal.model.entities.Tag;
import com.inmajimenez.proyectoFinal.model.request.TagFilters;
import com.inmajimenez.proyectoFinal.repository.TagRepository;
import com.inmajimenez.proyectoFinal.service.TagService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class TagServiceImpl implements TagService {

    private final Logger log = LoggerFactory.getLogger(TagServiceImpl.class);

    private TagDAO tagDAO;
    private TagRepository tagRepository;

    public TagServiceImpl (TagDAO tagDAO, TagRepository tagRepository){
        this.tagDAO = tagDAO;
        this.tagRepository = tagRepository;
    }

    /**
     * It returns a list of tags
     * @param filters Filters to look for tags
     * @return Response with list of tags
     */
    @Override
    public TagResponseGetAll findAllTags(TagFilters filters) {
        log.debug("Find all tags");
        return this.tagDAO.findAllTags(filters);
    }

    /**
     * It returns a tag depending of id
     * @param id Long id of tag
     * @return A tag
     */
    @Override
    public Tag findOneTagById(Long id) {
        log.debug("Find one tag by id: {}", id);
        return tagDAO.findOneTag(id);
    }

    /**
     * It saves a tag
     * @param tag New tag
     * @return The tag created
     */
    @Override
    public Tag createTag(Tag tag) {
        log.debug("Create tag: {}", tag);

        Tag tagCreated = null;

        if(tag.getId() == null){
            try{
                tag.setCreated_at(LocalDate.now());
                tag.setUpdated_at(LocalDate.now());
                tagCreated = tagRepository.save(tag);
            }catch(Exception e){
                log.error("Cannot save the tag: {}, error: {}", tag, e);
            }
        }else{
            log.warn("Creating tag with id");
        }
        return tagCreated;
    }

    /**
     * It updates a tag
     * @param tag The tag
     * @return The tag updated
     */
    @Override
    public Tag updateTag(Tag tag) {
        log.debug("Update a tag: {}", tag);

        Tag result = null;

        if (tag.getId() != null && tagRepository.existsById(tag.getId())) {
            try{
                tag.setUpdated_at(LocalDate.now());
                result = tagRepository.save(tag);
            }catch(Exception e){
                log.error("Cannot save tag: {} , error : {}", tag, e);
            }
        }else{
            log.warn("Cannot save tag: {}, because it doesn´t exist", tag);
        }
        return result;
    }

    /**
     * It deletes one tag by id
     *
     * @param id id of tag
     * @return true or false
     */
    @Override
    public boolean deleteTagById(Long id) {
        log.debug("Delete a tag by id: {}", id);

        if (tagRepository.existsById(id)) {
            try{
                if(tagDAO.deleteRelationWithExperts(id)){
                    tagRepository.deleteById(id);
                }else{
                    log.error("Cannot delete relation with expert of tag with id {}", id);
                    return false;
                }
            }catch(Exception e){
                log.error("Cannot delete tag with id {}", id);
                return false;
            }
        }else {
            log.error("Doesn´t exist tag with id {}", id);
            return false;
        }
        return true;
    }
}
