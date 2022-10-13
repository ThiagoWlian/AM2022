package com.amye.AMEY.REPOSITORY;

import com.amye.AMEY.MODEL.CandidatoVagasModel;
import com.amye.AMEY.MODEL.VagaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CandidatoVagasRepository extends JpaRepository<CandidatoVagasModel, Integer> {
    public Optional<CandidatoVagasModel> findByCandidatoVagasId(int id);

    public List<CandidatoVagasModel> findByVagasHabilidadesIdAndCandidatoId(int HabilidadeId, int candidatoId);

    public List<CandidatoVagasModel> findByCandidatoId(int id);
    public CandidatoVagasModel findByCandidatoIdAndVagasId(int candidatoId, int vagaId);

    @Query("SELECT v FROM VagaModel v WHERE v.id NOT IN (SELECT cvm.vagas.id FROM CandidatoVagasModel cvm WHERE cvm.candidato.id = ?1)")
    public List<VagaModel> findVagasByCandidatoNaoPossua(int idCandidato);
}
