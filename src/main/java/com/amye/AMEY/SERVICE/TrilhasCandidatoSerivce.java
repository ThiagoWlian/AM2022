package com.amye.AMEY.SERVICE;

import com.amye.AMEY.MODEL.*;
import com.amye.AMEY.REPOSITORY.TrilhaCandidatoRepository;
import com.amye.AMEY.SERVICE.TrilhaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Id;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TrilhasCandidatoSerivce {

    @Autowired
    private TrilhaCandidatoRepository trilhaCandidatoRepository;

    @Autowired
    private TrilhaService trilhaService;

    public void atualizarStatusParaTrue(int idCandidato, int idTrilha) {
        Optional<TrilhasCandidatoModel> candidatoModel = buscarTrilhaCandidatoPorCandidato(idCandidato,idTrilha);
        if(candidatoModel.isPresent()) {
            candidatoModel.get().setStatus(true);
            trilhaCandidatoRepository.save(candidatoModel.get());
        }
    }

    public void cadastrarNovo(CandidatoModel candidato, TrilhaModel trilha) {
        TrilhasCandidatoModel trilhasCandidatoModel = new TrilhasCandidatoModel(trilha,candidato, false);
        trilhaCandidatoRepository.save(trilhasCandidatoModel);
    }

    public Optional<TrilhasCandidatoModel> buscarTrilhaCandidatoPorCandidato(int idCandidato, int idTrilha) {
        return trilhaCandidatoRepository.findByCandidatoIdAndTrilhasId(idCandidato, idTrilha);
    }

    private boolean verificaSeExisteNoCadastrada(int idCandidato, int idTrilha) {
        Optional<TrilhasCandidatoModel> conteudo = trilhaCandidatoRepository.findByCandidatoIdAndTrilhasId(idCandidato, idTrilha);
        return conteudo.isEmpty();
    }

    @Transactional
    public void salvarTrilhasCandidatoPorListHabilidades(List<HabilidadeModel> listaHabilidades, CandidatoModel candidatoModel) {
        List<Optional<TrilhaModel>> listaTrilhas = trilhaService.buscarTrilhasPorHabilidades(listaHabilidades);
        for (Optional<TrilhaModel> trilha : listaTrilhas) {
            if(trilha.isPresent() && verificaSeExisteNoCadastrada(candidatoModel.getId(), trilha.get().getId())) {
                cadastrarNovo(candidatoModel, trilha.get());
            }
        }
    }
}
