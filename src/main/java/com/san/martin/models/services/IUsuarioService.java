package com.san.martin.models.services;

import java.util.List;

import com.san.martin.models.entity.Usuario;

public interface IUsuarioService {
	
	
	public Usuario findByUsername(String username);
	public List<Usuario> findAll();
	public Usuario findById(Long id);
	public Usuario saveUsuario(Usuario usuario);
	public void deleteusuarioById(Long id);
	
	
	
}
