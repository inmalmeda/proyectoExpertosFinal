package com.inmajimenez.proyectoFinal.service;

import com.inmajimenez.proyectoFinal.model.entities.User;

public interface UserService {
    /**
     * It returns an expert if it exist
     * @param user User
     * @return The user looged
     */
    User findOneUserLoggin(User user);

    /**
     * It saves an expert
     * @param user New user
     * @return The user created
     */
    User createUser(User user);
}
