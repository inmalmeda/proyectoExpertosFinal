package com.inmajimenez.proyectoFinal.dao;

import com.inmajimenez.proyectoFinal.model.ExpertFilters;
import com.inmajimenez.proyectoFinal.model.ExpertResponseGetAll;
import com.inmajimenez.proyectoFinal.model.entities.Expert;

import java.util.List;

/**
 * Class DAO for experts
 */
public interface ExpertDAO {

    /**
     * It returns a list of experts
     * @param filters Filters to look for experts
     * @return Response with list of experts
     */
    ExpertResponseGetAll findAllExperts(ExpertFilters filters);

    /**
     * It returns an expert depending of id
     * @param id Long id of expert
     * @return An expert
     */
    Expert findOneExpert(Long id);

}
