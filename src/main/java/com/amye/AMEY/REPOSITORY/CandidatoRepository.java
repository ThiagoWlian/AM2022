package com.amye.AMEY.REPOSITORY;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amye.AMEY.MODEL.CandidatoModel;

@Repository
public interface CandidatoRepository extends JpaRepository<CandidatoModel, Integer>{
	public Optional<CandidatoModel> findByUsuarioId(int id);
}
