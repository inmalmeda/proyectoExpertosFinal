package com.inmajimenez.proyectoFinal.repository;

import com.inmajimenez.proyectoFinal.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
