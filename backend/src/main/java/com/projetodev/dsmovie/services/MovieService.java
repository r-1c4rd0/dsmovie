package com.projetodev.dsmovie.services;

import com.projetodev.dsmovie.dto.MovieDTO;
import com.projetodev.dsmovie.entities.Movies;
import com.projetodev.dsmovie.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;

import org.springframework.transaction.annotation.Transactional;


@Service
public class MovieService {
    @Autowired
    private MovieRepository repository;

    @Transactional(readOnly = true)
    public Page<MovieDTO> findAll(Pageable pegeable){
       Page<Movies> result = repository.findAll(pegeable);
       Page<MovieDTO> page = result.map(x -> new MovieDTO(x));
        return page;
    }

    @Transactional(readOnly = true)
    public MovieDTO findById(Long id){
       Movies result = repository.findById(id).get();
       MovieDTO dto = new MovieDTO(result);
        return dto;
    }
}
