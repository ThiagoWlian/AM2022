package com.amye.AMEY.REPOSITORY;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amye.AMEY.MODEL.QuestaoModel;

public interface QuestaoRepository extends JpaRepository<QuestaoModel, Integer>{
	public List<QuestaoModel> findByProvaId(int id);
}
