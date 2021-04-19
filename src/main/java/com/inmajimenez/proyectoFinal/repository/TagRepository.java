package com.inmajimenez.proyectoFinal.repository;

import com.inmajimenez.proyectoFinal.model.entities.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository  extends JpaRepository<Tag, Long> {
}
