package com.amye.AMEY.REPOSITORY;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.amye.AMEY.MODEL.HabilidadeModel;

@Repository
public interface HabilidadesRepository extends JpaRepository<HabilidadeModel, Integer>{
	
	@Query("Select p From HabilidadeModel p Join p.vagas pe Where pe.id = ?1")
	public List<HabilidadeModel> findHabilidadesPorVagaId(int Id);
	
	public Optional<HabilidadeModel> findByNome(String nome);
}
