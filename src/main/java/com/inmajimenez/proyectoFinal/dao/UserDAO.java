package com.inmajimenez.proyectoFinal.dao;

import com.inmajimenez.proyectoFinal.model.entities.User;

public interface UserDAO {
    /**
     * It returns an expert if it exist
     * @param user User
     * @return The user looged
     */
    User findOneUserLoggin(User user);
}
