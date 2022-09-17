package com.amye.AMEY.REPOSITORY;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amye.AMEY.MODEL.TrilhaModel;

import java.util.List;
import java.util.Optional;

public interface TrilhaRepository extends JpaRepository<TrilhaModel, Integer>{
    public Optional<TrilhaModel> findByHabilidadesId(int id);

    public List<TrilhaModel> findByTrilhasCandidatoTrilhasIdAndTrilhasCandidatoStatus(int idCandidato, Boolean status);
}
