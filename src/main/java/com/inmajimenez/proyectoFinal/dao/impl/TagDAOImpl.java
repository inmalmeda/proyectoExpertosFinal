package com.inmajimenez.proyectoFinal.dao.impl;

import com.inmajimenez.proyectoFinal.dao.TagDAO;
import com.inmajimenez.proyectoFinal.model.Tag;
import com.inmajimenez.proyectoFinal.model.TagFilters;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
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
    public List<Tag> findAllTags(TagFilters filters) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Tag> criteria =  builder.createQuery(Tag.class);
        Root<Tag> root = criteria.from(Tag.class);

        if(filters.getName()!=null)
            criteria.select(root).where(builder.like(root.get("name"), filters.getName() + "%"));

        TypedQuery<Tag> tagsQuery = manager.createQuery(criteria);

        if(filters.getLimit()!=null && filters.getPage()!=null){
            tagsQuery.setFirstResult(Integer.parseInt(filters.getPage())); //Respresenta la posicion de comienzo, para indicar desde donde empezar
            tagsQuery.setMaxResults(Integer.parseInt(filters.getLimit()));//Representa size, el tamaño total, normalmente es 20
        }

        return tagsQuery.getResultList();
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
