package com.amye.AMEY.REPOSITORY;

import com.amye.AMEY.MODEL.TrilhasCandidatoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TrilhaCandidatoRepository extends JpaRepository<TrilhasCandidatoModel, Integer> {
    Optional<TrilhasCandidatoModel> findByCandidatoId(int id);

    Optional<TrilhasCandidatoModel> findByCandidatoIdAndTrilhasId(int idCandidato, int idTrilha);
}
