package com.inmajimenez.proyectoFinal.service.impl;

import com.inmajimenez.proyectoFinal.dao.UserDAO;
import com.inmajimenez.proyectoFinal.model.entities.User;
import com.inmajimenez.proyectoFinal.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    private UserDAO userDAO;

    public UserServiceImpl(UserDAO userDAO){
        this.userDAO = userDAO;
    }

    /**
     * It returns an expert if it exist
     *
     * @param user User
     * @return The user looged
     */
    @Override
    public User findOneUserLoggin(User user) {
        log.debug("Find user");
        return  userDAO.findOneUserLoggin(user);
    }
}
