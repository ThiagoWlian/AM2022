package com.amye.AMEY.REPOSITORY;

import com.amye.AMEY.MODEL.FormacoesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormacoesRepository extends JpaRepository<FormacoesModel, Integer> {
}
