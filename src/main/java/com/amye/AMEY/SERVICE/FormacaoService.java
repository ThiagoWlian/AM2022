package com.amye.AMEY.SERVICE;

import com.amye.AMEY.MODEL.CurriculoModel;
import com.amye.AMEY.MODEL.FormacoesModel;
import com.amye.AMEY.REPOSITORY.FormacoesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormacaoService {

    @Autowired
    FormacoesRepository formacoesRepository;

    public FormacoesModel cadastrarFormacao(FormacoesModel formacoesModel) {
        return formacoesRepository.save(formacoesModel);
    }

    public void cadastrarListaFormacao(List<FormacoesModel> formacoesModelList) {
        formacoesModelList.stream().forEach(e -> formacoesRepository.save(e));
    }
}
