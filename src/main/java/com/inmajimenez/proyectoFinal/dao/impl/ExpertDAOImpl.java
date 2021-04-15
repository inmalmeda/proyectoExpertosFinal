package com.inmajimenez.proyectoFinal.dao.impl;

import com.inmajimenez.proyectoFinal.dao.ExpertDAO;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class ExpertDAOImpl implements ExpertDAO {

    @PersistenceContext
    private EntityManager manager;
}
