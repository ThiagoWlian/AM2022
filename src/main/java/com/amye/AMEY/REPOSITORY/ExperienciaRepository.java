package com.amye.AMEY.REPOSITORY;

import com.amye.AMEY.MODEL.CandidatoModel;
import com.amye.AMEY.MODEL.ExperienciaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ExperienciaRepository extends JpaRepository<ExperienciaModel, Integer> {

    @Query("SELECT c FROM CandidatoVagasModel cv JOIN CandidatoModel c ON c.id = cv.candidato.id JOIN CurriculoModel cu ON cu.candidato.id = c.id JOIN ExperienciaModel ex ON ex.curriculo.id = cu.id WHERE ex.titulo like %?2% AND cv.vagas.id = ?1")
    public List<CandidatoModel> findByExperienciaNome(int idVaga ,String filtro);

    @Query("SELECT c FROM CandidatoModel c JOIN CurriculoModel cu ON cu.candidato.id = c.id JOIN ExperienciaModel ex ON ex.curriculo.id = cu.id WHERE ex.titulo like %?1%")
    public List<CandidatoModel> findByExperienciaNome(String filtro);

}
