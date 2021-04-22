package com.inmajimenez.proyectoFinal.dao.impl;

import com.inmajimenez.proyectoFinal.dao.TagDAO;
import com.inmajimenez.proyectoFinal.model.TagResponseGetAll;
import com.inmajimenez.proyectoFinal.model.entities.Tag;
import com.inmajimenez.proyectoFinal.model.TagFilters;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class TagDAOImpl implements TagDAO {

    @PersistenceContext
    private EntityManager manager;

    /**
     * It returns a list of tags
     * @param filters Filters to look for tags
     * @return Response with list of tags
     */
    @Override
    public TagResponseGetAll findAllTags(TagFilters filters) {

        TagResponseGetAll responseGet = new TagResponseGetAll();

        CriteriaBuilder builder = manager.getCriteriaBuilder();
        //Criteria List
        CriteriaQuery<Tag> criteria =  builder.createQuery(Tag.class);
        Root<Tag> root = criteria.from(Tag.class);
        //Criteria Count
        CriteriaQuery<Long> criteriaCount = builder.createQuery(Long.class);
        Root<Tag> rootCount = criteriaCount.from(Tag.class);
        criteriaCount.select((builder.countDistinct(rootCount)));

        if(filters.getName()!=null){
            criteria.select(root).where(builder.like(root.get("name"), filters.getName() + "%"));
            criteriaCount.where(builder.like(rootCount.get("name"), filters.getName() + "%"));
        }

        responseGet.setTotalCount(manager.createQuery(criteriaCount).getSingleResult());

        TypedQuery<Tag> tagsQuery = manager.createQuery(criteria);

        if(filters.getLimit()!=null && filters.getPage()!=null){
            tagsQuery.setFirstResult(Integer.parseInt(filters.getPage()));
            tagsQuery.setMaxResults(Integer.parseInt(filters.getLimit()));
        }

        responseGet.setTags(tagsQuery.getResultList());

        return responseGet;
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

    /**
     * It deletes the relation with expert in tags in table expert_tag
     * @param id of tag
     * @return true or false
     */
    @Transactional
    @Override
    public Boolean deleteRelationWithExperts(Long id) {

        Query queryNative = manager.createNativeQuery("delete from expert_tag where tag_id = "+ id);
        if(id!=null) {
            try {
                queryNative.executeUpdate();
            }catch (Exception e){
               return false;
            }
            return true;
        }
        return false;
    }
}
