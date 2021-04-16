package com.inmajimenez.proyectoFinal.dao.impl;

import com.inmajimenez.proyectoFinal.dao.ExpertDAO;
import com.inmajimenez.proyectoFinal.model.Expert;
import com.inmajimenez.proyectoFinal.model.Tag;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class ExpertDAOImpl implements ExpertDAO {

    @PersistenceContext
    private EntityManager manager;

    /**
     * It returns a list of experts
     * @return List of experts
     */
    @Override
    public List<Expert> findAllExperts() {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Expert> criteria =  builder.createQuery(Expert.class);
        Root<Expert> root = criteria.from(Expert.class);

        //TODO FALTAN LOS FILTROS Y PAGINACION!!!!!

        try{
            return manager.createQuery(criteria).getResultList();
        }catch(Exception e){
            return null;
        }
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
