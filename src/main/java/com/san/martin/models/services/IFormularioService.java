package com.san.martin.models.services;

import java.util.List;

import com.san.martin.models.entity.Formulario;

public interface IFormularioService {

	public List<Formulario> findAll();
	public 	Formulario findById(Long id);
	public  Formulario saveFormulario(Formulario formulario);
	public void deleteformularioById(Long id);
	 public List<Formulario> findByUserId(Long id);
	
}
