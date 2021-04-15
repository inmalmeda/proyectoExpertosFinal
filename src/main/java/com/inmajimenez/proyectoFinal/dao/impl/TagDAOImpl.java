package com.inmajimenez.proyectoFinal.dao.impl;

import com.inmajimenez.proyectoFinal.dao.TagDAO;
import com.inmajimenez.proyectoFinal.model.Tag;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class TagDAOImpl implements TagDAO {

    @PersistenceContext
    private EntityManager manager;

    /**
     * It returns a list of tags
     * @return List of tags
     */
    @Override
    public List<Tag> findAllTags() {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Tag> criteria =  builder.createQuery(Tag.class);
        Root<Tag> root = criteria.from(Tag.class);

        //TODO FALTAN LOS FILTROS Y PAGINACION!!!!!

        try{
            return manager.createQuery(criteria).getResultList();
        }catch(Exception e){
            return null;
        }
    }

    /**
     * It returns a tag depending of id
     * @param id Long id of tag
     * @return A tag
     */
    @Override
    public Tag findOneTag(Long id) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Tag> criteria =  builder.createQuery(Tag.class);
        Root<Tag> root = criteria.from(Tag.class);
        Tag tag;

        criteria.select(root).where(builder.equal(root.get("id"), id));
        try{
            tag = manager.createQuery(criteria).getSingleResult();
        }catch(Exception e){
            tag = null;
        }
        return tag;
    }
}
