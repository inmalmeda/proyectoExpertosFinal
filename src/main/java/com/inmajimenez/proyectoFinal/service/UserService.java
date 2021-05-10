package com.inmajimenez.proyectoFinal.service;

import com.inmajimenez.proyectoFinal.model.entities.User;
import com.inmajimenez.proyectoFinal.model.request.LoginRequest;
import com.inmajimenez.proyectoFinal.model.request.SignupRequest;
import com.inmajimenez.proyectoFinal.model.response.LoginResponse;

public interface UserService {
    /**
     * It returns an expert if it exist
     * @param login LoginRequest
     * @return The user looged
     */
    LoginResponse checkLoginUser(LoginRequest login);

    /**
     * It saves an expert
     * @param user New user
     * @return True or false
     */
    Boolean createUser(SignupRequest user);

    Boolean checkEmailUser(String email);

}
