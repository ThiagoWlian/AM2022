package com.amye.AMEY.REPOSITORY;

import com.amye.AMEY.MODEL.CandidatoVagasModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CandidatoVagasRepository extends JpaRepository<CandidatoVagasModel, Integer> {
    public Optional<CandidatoVagasModel> findByCandidatoVagasId(int id);

    public List<CandidatoVagasModel> findByVagasHabilidadesIdAndCandidatoId(int HabilidadeId, int candidatoId);

    public List<CandidatoVagasModel> findByCandidatoId(int id);
}
