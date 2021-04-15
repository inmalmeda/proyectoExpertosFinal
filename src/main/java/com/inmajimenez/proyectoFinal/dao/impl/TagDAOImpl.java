package com.inmajimenez.proyectoFinal.dao.impl;

import com.inmajimenez.proyectoFinal.dao.TagDAO;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class TagDAOImpl implements TagDAO {

    @PersistenceContext
    private EntityManager manager;
}
