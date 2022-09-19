package com.amye.AMEY.SERVICE;


import com.amye.AMEY.DTO.JSONCONVERT.Skills;
import org.springframework.stereotype.Service;

import com.amye.AMEY.DTO.JSONCONVERT.Data;
import com.google.gson.Gson;

@Service
public class CurriculoService {

    public void converteJsonEmObjeto(String json) {
    	Data data = new Gson().fromJson(json, Data.class);
    }
}
