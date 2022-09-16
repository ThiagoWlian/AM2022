package com.amye.AMEY.REPOSITORY;

import com.amye.AMEY.MODEL.CandidatoVagasModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidatoVagasController extends JpaRepository<CandidatoVagasModel, Integer> {
}
