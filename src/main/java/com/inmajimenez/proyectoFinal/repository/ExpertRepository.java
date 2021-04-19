package com.inmajimenez.proyectoFinal.repository;

import com.inmajimenez.proyectoFinal.model.entities.Expert;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpertRepository  extends JpaRepository<Expert, Long> {
}
