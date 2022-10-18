package com.amye.AMEY.REPOSITORY;

import com.amye.AMEY.MODEL.CandidatoModel;
import com.amye.AMEY.MODEL.FormacoesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FormacoesRepository extends JpaRepository<FormacoesModel, Integer> {

    @Query("SELECT c FROM CandidatoVagasModel cv JOIN CandidatoModel c ON c.id = cv.candidato.id JOIN CurriculoModel cu ON cu.id = c.id JOIN FormacoesModel f ON f.curriculo.id = cu.id WHERE cv.vagas.id = ?1 AND f.titulo LIKE %?2%")
    public List<CandidatoModel> findCandidatoByNomeExperiencia(int idVaga, String filtro);

    @Query("SELECT c FROM CandidatoModel c JOIN CurriculoModel cu ON cu.id = c.id JOIN FormacoesModel f ON f.curriculo.id = cu.id WHERE f.titulo LIKE %?1%")
    public List<CandidatoModel> findCandidatoByNomeExperiencia(String filtro);
}
