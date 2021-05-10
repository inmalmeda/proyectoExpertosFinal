package com.inmajimenez.proyectoFinal.service.impl;

import com.inmajimenez.proyectoFinal.model.entities.User;
import com.inmajimenez.proyectoFinal.model.request.LoginRequest;
import com.inmajimenez.proyectoFinal.model.request.SignupRequest;
import com.inmajimenez.proyectoFinal.model.response.LoginResponse;
import com.inmajimenez.proyectoFinal.repository.UserRepository;
import com.inmajimenez.proyectoFinal.security.jwt.JwtTokenUtil;
import com.inmajimenez.proyectoFinal.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    private final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtTokenUtil jwtTokenUtil;

    /**
     * It returns an expert if it exist
     *
     * @param login LoginRequest
     * @return The user looged
     */
    @Override
    public LoginResponse checkLoginUser(LoginRequest login) {
        log.debug("Find user");

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(login.getEmail(), login.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtTokenUtil.generateJwtToken(authentication);
    //    UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        return new LoginResponse(userRepository.findByEmail(login.getEmail()).get().getName(),login.getEmail(),jwt);
    }


    /**
     * It saves an user
     *
     * @param user New user
     * @return The user created
     */
    @Override
    public Boolean createUser(SignupRequest user) {
        log.debug("Create user: {}", user);

        User userCreated = new User(null, user.getUsername(), user.getEmail(), encoder.encode(user.getPassword()));

        try{
            userRepository.save(userCreated);

        } catch(Exception e) {
            log.error("Cannot save the user: {} , error : {}", user, e);
            return false;
        }

        return true;
    }

    @Override
    public Boolean checkEmailUser(String email) {
        return userRepository.existsByEmail(email);
    }
}
