package com.amye.AMEY.REPOSITORY;

import java.util.List;
import java.util.Optional;

import com.amye.AMEY.DTO.CandidatoModelPontosDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.amye.AMEY.MODEL.CandidatoModel;

@Repository
public interface CandidatoRepository extends JpaRepository<CandidatoModel, Integer>{
	public Optional<CandidatoModel> findByUsuarioId(int id);

	@Query("SELECT new com.amye.AMEY.DTO.CandidatoModelPontosDto(c.id, c.nome, c.sobrenome, cv.pontos) FROM CandidatoModel c JOIN CandidatoVagasModel cv ON cv.candidato.id = c.id WHERE cv.vagas.id = ?1 ORDER BY cv.pontos DESC")
	public List<CandidatoModelPontosDto> findByVagasOrderByPontosDesc(int idVaga);

	@Query("SELECT c FROM CandidatoVagasModel cv JOIN CandidatoModel c ON c.id = cv.candidato.id JOIN CurriculoModel cu ON cu.candidato.id = c.id JOIN cu.habilidades h WHERE h.nome LIKE %?2% AND cv.vagas.id = ?1")
	public List<CandidatoModel> findByVagasHabilidadeOrderByPontosDesc(int idVaga, String filtro);

	@Query("SELECT c FROM CandidatoModel c JOIN CurriculoModel cu ON cu.candidato.id = c.id JOIN cu.habilidades h WHERE h.nome LIKE %?1%")
	public List<CandidatoModel> findByVagasHabilidadeOrderByPontosDesc(String filtro);

	@Query("SELECT c FROM CandidatoModel c JOIN CandidatoVagasModel cv ON cv.candidato.id = c.id WHERE cv.vagas.id = ?1 AND c.nome LIKE %?2% ORDER BY c.pontos DESC")
	public List<CandidatoModel> findByVagasCandidatoNomeOrderByPontosDesc(int idVaga, String filtro);

	@Query("SELECT c FROM CandidatoModel c WHERE c.nome LIKE %?1% ORDER BY c.pontos DESC")
	public List<CandidatoModel> findByVagasCandidatoNomeOrderByPontosDesc(String filtro);

	@Query("SELECT c FROM CandidatoModel c JOIN CandidatoVagasModel cv ON cv.candidato.id = c.id WHERE cv.vagas.id = ?1 AND c.sobrenome LIKE %?2% ORDER BY c.pontos DESC")
	public List<CandidatoModel> findByVagasCandidatoSobrenomeOrderByPontosDesc(int idVaga, int filtro);

	@Query("SELECT c FROM CandidatoModel c JOIN CandidatoVagasModel cv ON cv.candidato.id = c.id WHERE cv.vagas.id = ?1 AND c.pontos > ?2 ORDER BY c.pontos DESC")
	public List<CandidatoModel> findByVagasCandidatoPontosOrderByPontosDesc(int idVaga, String filtro);
}
