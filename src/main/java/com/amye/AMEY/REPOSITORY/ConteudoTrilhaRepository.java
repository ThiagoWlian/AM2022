package com.amye.AMEY.REPOSITORY;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amye.AMEY.MODEL.ConteudoTrilhaModel;

public interface ConteudoTrilhaRepository extends JpaRepository<ConteudoTrilhaModel, Integer>{
	public List<ConteudoTrilhaModel> findByTrilhasId(int id);
}
