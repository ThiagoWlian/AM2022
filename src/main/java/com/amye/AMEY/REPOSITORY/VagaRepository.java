package com.amye.AMEY.REPOSITORY;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amye.AMEY.MODEL.VagaModel;

@Repository
public interface VagaRepository extends JpaRepository<VagaModel, Integer>{

}
