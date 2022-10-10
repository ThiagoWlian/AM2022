package com.amye.AMEY.REPOSITORY;

import java.util.List;

import com.amye.AMEY.DTO.VagasAdmDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.amye.AMEY.MODEL.VagaModel;

@Repository
public interface VagaRepository extends JpaRepository<VagaModel, Integer>{
	
	public List<VagaModel> findAllByCandidatosId(int id);
	public List<VagaModel> findAllByCandidatosIdNot(int id);

	@Query("SELECT new com.amye.AMEY.DTO.VagasAdmDto(v.id, v.nome, COUNT(cv.id)) FROM VagaModel v JOIN CandidatoVagasModel cv ON cv.vagas.id = v.id")
	public List<VagasAdmDto> findAllQuantidade();

	@Query("SELECT new com.amye.AMEY.DTO.VagasAdmDto(v.id, v.nome, COUNT(cv.id)) FROM VagaModel v JOIN CandidatoVagasModel cv ON cv.vagas.id = v.id WHERE v.nome LIKE %?1%")
	public List<VagasAdmDto> findAllQuantidadeFiltro(String filtro);
}
