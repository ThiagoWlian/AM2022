package com.amye.AMEY.REPOSITORY;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amye.AMEY.MODEL.ProfissoesModel;

@Repository
public interface ProfissoesRepository extends JpaRepository<ProfissoesModel, Integer>{
}
