package com.amye.AMEY.SERVICE;


import com.amye.AMEY.DTO.JSONCONVERT.Skills;
import com.amye.AMEY.MODEL.CurriculoModel;
import com.amye.AMEY.MODEL.ExperienciaModel;
import com.amye.AMEY.MODEL.FormacoesModel;
import com.amye.AMEY.MODEL.HabilidadeModel;
import com.amye.AMEY.REPOSITORY.CurriculoRepository;
import com.amye.AMEY.REPOSITORY.ExperienciaRepository;
import com.amye.AMEY.REPOSITORY.FormacoesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amye.AMEY.DTO.JSONCONVERT.Data;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CurriculoService {

    @Autowired
    private CurriculoRepository curriculoRepository;

    @Autowired
    private FormacoesRepository formacoesRepository;

    @Autowired
    private ExperienciaRepository experienciaRepository;

    @Autowired
    private HabilidadesService habilidadesService;

    public Data converteJsonEmObjeto(String json) {
    	Data data = new Gson().fromJson(json, Data.class);
        return data;
    }

    public void criarNovoCurriculo(CurriculoModel curriculoModel) {
        CurriculoModel curriculoCadastro = new CurriculoModel(curriculoModel);
        CurriculoModel curriculoCadastrado = curriculoRepository.save(curriculoCadastro);
        List<FormacoesModel> formacoesModelList = curriculoModel.getFormacoes();
        List<ExperienciaModel> experienciaModelList = curriculoModel.getExperiencias();
        List<HabilidadeModel> habilidadeModelList = curriculoModel.getHabilidades();

        CurriculoModel finalCurriculoModel = curriculoCadastrado;
        formacoesModelList.forEach(e -> e.setCurriculo(finalCurriculoModel));
        experienciaModelList.forEach(e -> e.setCurriculo(finalCurriculoModel));
        habilidadeModelList.forEach(e -> e.setCurriculo(new ArrayList<>(Arrays.asList(finalCurriculoModel))));

        formacoesRepository.saveAll(formacoesModelList);
        experienciaRepository.saveAll(experienciaModelList);
        habilidadesService.cadastarListaDeHabilidades(habilidadeModelList);

    }

    public CurriculoModel buscarCurriculoPeloCandidato(int idCandditado) {
        return curriculoRepository.findByCandidatoId(idCandditado).get();
    }
}
