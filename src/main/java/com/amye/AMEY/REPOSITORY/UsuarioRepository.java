package com.amye.AMEY.REPOSITORY;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amye.AMEY.MODEL.UsuarioModel;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Integer>{
	Optional<UsuarioModel> findByUsernameAndPassword(String username, String password);
}
