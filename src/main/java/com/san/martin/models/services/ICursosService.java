package com.san.martin.models.services;

import java.util.List;

import com.san.martin.models.entity.Cursos;

public interface ICursosService {

	public List<Cursos> findAll();
	
	public Cursos findById(Long id);
	
	public Cursos save(Cursos cursos);
	
	public void delete(Long id);
}
