package com.amye.AMEY.REPOSITORY;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amye.AMEY.MODEL.TrilhaModel;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TrilhaRepository extends JpaRepository<TrilhaModel, Integer>{
    public Optional<TrilhaModel> findByHabilidadesId(int id);

    public List<TrilhaModel> findByTrilhasCandidatoCandidatoIdAndTrilhasCandidatoStatus(int idCandidato, Boolean status);

    public Optional<TrilhaModel> findByProvasId(int id);

    @Query("SELECT t FROM TrilhaModel t WHERE t.nome like %?1%")
    public List<TrilhaModel> findByTrilhasCandidatoCandidatoIdAndTrilhasCandidatoStatusAndAndNomeLikeIgnoreCase(int idCandidato, Boolean status, String nome);
}
