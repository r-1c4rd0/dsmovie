package com.projetodev.dsmovie.repositories;

import com.projetodev.dsmovie.entities.Score;
import com.projetodev.dsmovie.entities.ScorePK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScoreRepository extends JpaRepository<Score, ScorePK> {
}
