package com.amye.AMEY.REPOSITORY;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amye.AMEY.MODEL.TrilhaModel;

import java.util.Optional;

public interface TrilhaRepository extends JpaRepository<TrilhaModel, Integer>{
    Optional<TrilhaModel> findByHabilidadesId(int id);
}
