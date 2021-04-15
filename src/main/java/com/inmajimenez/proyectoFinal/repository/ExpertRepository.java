package com.inmajimenez.proyectoFinal.repository;

import com.inmajimenez.proyectoFinal.model.Expert;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpertRepository  extends JpaRepository<Expert, Long> {
}
