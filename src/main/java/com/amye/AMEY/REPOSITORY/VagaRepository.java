package com.amye.AMEY.REPOSITORY;

import java.util.List;

import com.amye.AMEY.DTO.VagasAdmDto;
import com.amye.AMEY.MODEL.CandidatoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.amye.AMEY.MODEL.VagaModel;

@Repository
public interface VagaRepository extends JpaRepository<VagaModel, Integer>{
	
	public List<VagaModel> findAllByCandidatosId(int id);
	public List<VagaModel> findAllByCandidatosIdNot(int id);

	@Query("SELECT v FROM VagaModel v WHERE v.nome LIKE %?1%")
	public List<VagaModel> findByVagaNome(String filtro);

	@Query("SELECT new com.amye.AMEY.DTO.VagasAdmDto(cv.vagas.id, cv.vagas.nome, COUNT(cv.id)) FROM CandidatoVagasModel cv group by cv.vagas.id")
	public List<VagasAdmDto> findAllQuantidade();

	@Query("SELECT new com.amye.AMEY.DTO.VagasAdmDto(v.id, v.nome, COUNT(cv.id)) FROM VagaModel v JOIN CandidatoVagasModel cv ON cv.vagas.id = v.id WHERE v.nome LIKE %?1%")
	public List<VagasAdmDto> findAllQuantidadeFiltro(String filtro);

	@Query("SELECT v FROM VagaModel v WHERE v.nome like %?1%")
	public List<VagaModel> findAllByNome(String filtro);
}
