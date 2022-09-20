package com.amye.AMEY.SERVICE;

import com.amye.AMEY.MODEL.ExperienciaModel;
import com.amye.AMEY.REPOSITORY.ExperienciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExperienciaService {

    @Autowired
    ExperienciaRepository experienciaRepository;

    public void criarNovaExperiencia(ExperienciaModel experienciaModel) {
        experienciaRepository.save(experienciaModel);
    }

    public void cadastrarListaExperiencia(List<ExperienciaModel> experienciaModels) {
        experienciaModels.forEach(e -> experienciaRepository.save(e));
    }
}
