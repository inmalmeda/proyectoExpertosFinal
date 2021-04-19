package com.inmajimenez.proyectoFinal.service;

import com.inmajimenez.proyectoFinal.model.ExpertFilters;
import com.inmajimenez.proyectoFinal.model.entities.Expert;

import java.util.List;

/**
 * Class service for experts
 */
public interface ExpertService {
    /**
     * It returns a list of experts
     *  @param filters Filters to look for experts
     * @return List of experts
     */
    List<Expert> findAllExperts(ExpertFilters filters);

    /**
     * It returns an expert depending of id
     * @param id Long id of expert
     * @return An expert
     */
    Expert findOneExpertById(Long id);

    /**
     * It saves an expert
     * @param expert New expert
     * @return The expert created
     */
    Expert createExpert(Expert expert);

    /**
     * It updates an expert
     * @param expert The expert
     * @return The expert updated
     */
    Expert updateExpert(Expert expert);

    /**
     * It deletes one expert by id
     * @param id id of expert
     * @return true or false
     */
    boolean deleteExpertById(Long id);
}
