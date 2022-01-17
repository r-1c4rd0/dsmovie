package com.projetodev.dsmovie.services;

import com.projetodev.dsmovie.dto.MovieDTO;
import com.projetodev.dsmovie.dto.ScoreDTO;
import com.projetodev.dsmovie.entities.Movies;
import com.projetodev.dsmovie.entities.Score;
import com.projetodev.dsmovie.entities.User;
import com.projetodev.dsmovie.repositories.MovieRepository;
import com.projetodev.dsmovie.repositories.ScoreRepository;
import com.projetodev.dsmovie.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ScoreService {
    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ScoreRepository scoreRepository;

    @Transactional
    public MovieDTO saveScore(ScoreDTO dto){
        User user = userRepository.findByEmail(dto.getEmail());
        if (user==null){
            user = new User();
            user.setEmail(dto.getEmail());
            user = userRepository.saveAndFlush(user);
        }
        Movies movies = movieRepository.findById(dto.getMovieId()).get();

        Score score = new Score();
        score.setMovie(movies);
        score.setUser(user);
        score.setValue(dto.getScore());

        score = scoreRepository.saveAndFlush(score);
        double sum = 0.0;
        for (Score s : movies.getScores()) {
            sum = sum + s.getValue();
        }

        double avg = sum / movies.getScores().size();

        movies.setScore(avg);
        movies.setCount(movies.getScores().size());

        movies = movieRepository.save(movies);

        return new MovieDTO(movies);

    }


}
