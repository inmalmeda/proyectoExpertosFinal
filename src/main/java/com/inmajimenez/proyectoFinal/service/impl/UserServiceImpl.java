package com.inmajimenez.proyectoFinal.service.impl;

import com.inmajimenez.proyectoFinal.dao.UserDAO;
import com.inmajimenez.proyectoFinal.model.entities.User;
import com.inmajimenez.proyectoFinal.repository.UserRepository;
import com.inmajimenez.proyectoFinal.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    private final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    private UserDAO userDAO;
    private UserRepository userRepository;

    public UserServiceImpl(UserDAO userDAO, UserRepository userRepository){
        this.userDAO = userDAO;
        this.userRepository = userRepository;
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

    /**
     * It saves an user
     *
     * @param user New user
     * @return The user created
     */
    @Override
    public User createUser(User user) {
        log.debug("Create user: {}", user);

        User userCreated = null;

        if (user.getId() == null) {
            try{
                userCreated = userRepository.save(user);
            }catch(Exception e) {
                log.error("Cannot save the user: {} , error : {}", user, e);
            }
        }else{
            log.warn("Creating expert with id");
        }
        return userCreated;
    }
}
