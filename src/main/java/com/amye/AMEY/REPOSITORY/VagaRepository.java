package com.amye.AMEY.REPOSITORY;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.amye.AMEY.MODEL.VagaModel;

@Repository
public interface VagaRepository extends JpaRepository<VagaModel, Integer>{
	
	public List<VagaModel> findAllByCandidatosId(int id);
}
