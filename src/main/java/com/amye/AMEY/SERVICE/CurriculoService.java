package com.amye.AMEY.SERVICE;


import com.amye.AMEY.DTO.JSONCONVERT.Skills;
import com.amye.AMEY.MODEL.CurriculoModel;
import com.amye.AMEY.REPOSITORY.CurriculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amye.AMEY.DTO.JSONCONVERT.Data;
import com.google.gson.Gson;

@Service
public class CurriculoService {

    @Autowired
    private CurriculoRepository curriculoRepository;

    public Data converteJsonEmObjeto(String json) {
    	Data data = new Gson().fromJson(json, Data.class);
        return data;
    }

    public CurriculoModel criarNovoCurriculo(CurriculoModel curriculoModel) {
        return curriculoRepository.save(curriculoModel);
    }
}
