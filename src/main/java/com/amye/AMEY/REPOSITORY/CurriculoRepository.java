package com.amye.AMEY.REPOSITORY;

import com.amye.AMEY.MODEL.CurriculoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurriculoRepository extends JpaRepository<CurriculoModel,Integer> {
}
