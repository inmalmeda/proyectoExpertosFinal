package com.inmajimenez.proyectoFinal.dao;

import com.inmajimenez.proyectoFinal.model.Expert;
import com.inmajimenez.proyectoFinal.model.Tag;

import java.util.List;

/**
 * Class DAO for experts
 */
public interface ExpertDAO {

    /**
     * It returns a list of experts
     * @return List of experts
     */
    List<Expert> findAllExperts();

    /**
     * It returns an expert depending of id
     * @param id Long id of expert
     * @return An expert
     */
    Expert findOneExpert(Long id);

}
