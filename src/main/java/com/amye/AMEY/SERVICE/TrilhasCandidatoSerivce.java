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

    public void atualizarStatus(int idCandidato) {
        Optional<TrilhasCandidatoModel> candidatoModel = buscarTrilhaCandidatoPorCandidato(idCandidato);
        if(candidatoModel.isPresent()) {
            candidatoModel.get().setStatus(true);
            trilhaCandidatoRepository.save(candidatoModel.get());
        }
    }

    public void cadastrarNovo(CandidatoModel candidato, TrilhaModel trilha) {
        TrilhasCandidatoModel trilhasCandidatoModel = new TrilhasCandidatoModel(trilha,candidato, false);
        trilhaCandidatoRepository.save(trilhasCandidatoModel);
    }

    public Optional<TrilhasCandidatoModel> buscarTrilhaCandidatoPorCandidato(int idCandidato) {
        return trilhaCandidatoRepository.findByCandidatoId(idCandidato);
    }

    @Transactional
    public void salvarTrilhasCandidatoPorListHabilidades(List<HabilidadeModel> listaHabilidades, CandidatoModel candidatoModel) {
        List<TrilhaModel> listaTrilhas = trilhaService.buscarTrilhasPorHabilidades(listaHabilidades);
        listaTrilhas.forEach(e -> cadastrarNovo(candidatoModel,e));
    }
}
