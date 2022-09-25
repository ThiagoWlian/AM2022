package com.amye.AMEY.SERVICE;

import com.amye.AMEY.MODEL.CandidatoModel;
import com.amye.AMEY.MODEL.CandidatoVagasModel;
import com.amye.AMEY.MODEL.HabilidadeModel;
import com.amye.AMEY.REPOSITORY.CandidatoVagasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VagaCandidatoService {

    @Autowired
    private CandidatoVagasRepository candidatoVagasRepository;

    public List<CandidatoVagasModel> buscarCandidatosVagas(List<HabilidadeModel> habilidades, CandidatoModel candidatoModel) {
        List<CandidatoVagasModel> vagas = new ArrayList<>();
        List<Integer> listaIds = new ArrayList<>();

        for (HabilidadeModel habilidadeModel : habilidades) {
            List<CandidatoVagasModel> listaVagas = candidatoVagasRepository.findByVagasHabilidadesIdAndCandidatoId(habilidadeModel.getId(), candidatoModel.getId());
            for (CandidatoVagasModel candidatoVagasModel : listaVagas) {
                if(!listaIds.contains(candidatoVagasModel.getId())) {
                    listaIds.add(candidatoModel.getId());
                    vagas.add(candidatoVagasModel);
                }
            }
        }
        return vagas;
    }

    public void aumentarPontos(List<CandidatoVagasModel> candidatoVagasModels, int pontos) {
        for (CandidatoVagasModel candidatoVagas : candidatoVagasModels) {
            candidatoVagas.aumentarPontos(pontos);
            candidatoVagasRepository.save(candidatoVagas);
        }
    }

    public void aumentarPontos(CandidatoVagasModel candidatoVagasModels, int pontos) {
        candidatoVagasModels.aumentarPontos(pontos);
        candidatoVagasRepository.save(candidatoVagasModels);
    }

    public List<CandidatoVagasModel> buscarCandidatoVagaModelPeloCandidato(int idCandidato) {
        return candidatoVagasRepository.findByCandidatoId(idCandidato);
    }

}
