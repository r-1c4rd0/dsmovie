package com.projetodev.dsmovie.repositories;

import com.projetodev.dsmovie.entities.Movies;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movies, Long> {
}
