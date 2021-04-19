package com.inmajimenez.proyectoFinal.dao.impl;

import com.inmajimenez.proyectoFinal.dao.ExpertDAO;
import com.inmajimenez.proyectoFinal.model.ExpertFilters;
import com.inmajimenez.proyectoFinal.model.entities.Expert;
import io.swagger.models.Tag;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class ExpertDAOImpl implements ExpertDAO {

    @PersistenceContext
    private EntityManager manager;

    /**
     * It returns a list of experts
     * @param filters Filters to look for experts
     * @return List of experts
     */
    @Override
    public List<Expert> findAllExperts(ExpertFilters filters) {

        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Expert> criteria =  builder.createQuery(Expert.class);
        Root<Expert> root = criteria.from(Expert.class);
        Join<Expert, Tag> rootTags = root.join("tags");

        List<Predicate> predicates = new ArrayList<>();

        if(filters.getName()!=null)
            predicates.add(builder.like(root.get("name"), filters.getName() + "%"));

        if(filters.getMode()!=null)
            predicates.add(builder.equal(root.get("modality"), filters.getMode()));

        if(filters.getState()!=null)
            predicates.add(builder.equal(root.get("state"), filters.getState()));

        if(filters.getScore()!=null)
            predicates.add(builder.equal(root.get("score"), filters.getScore()));

        if(filters.getTag()!=null)
            predicates.add(builder.equal(rootTags.get("id"), filters.getTag()));

        criteria.distinct(true).select(root).where(builder.and(predicates.toArray(new Predicate[0])));

        TypedQuery<Expert> expertsQuery = manager.createQuery(criteria);

        if(filters.getLimit()!=null && filters.getPage()!=null){
            expertsQuery.setFirstResult(Integer.parseInt(filters.getPage())); //Respresenta la posicion de comienzo, para indicar desde donde empezar
            expertsQuery.setMaxResults(Integer.parseInt(filters.getLimit()));//Representa size, el tamaño total, normalmente es 20
        }
        return expertsQuery.getResultList();
    }

    /**
     * It returns an expert depending of id
     *
     * @param id Long id of expert
     * @return An expert
     */
    @Override
    public Expert findOneExpert(Long id) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Expert> criteria =  builder.createQuery(Expert.class);
        Root<Expert> root = criteria.from(Expert.class);
        Expert expert;

        criteria.select(root).where(builder.equal(root.get("id"), id));
        try{
            expert = manager.createQuery(criteria).getSingleResult();
        }catch(Exception e){
            expert = null;
        }
        return expert;
    }
}
