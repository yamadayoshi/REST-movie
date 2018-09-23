package com.web.repository;

import org.springframework.data.repository.CrudRepository;

import com.web.classes.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, String> {
	
}
