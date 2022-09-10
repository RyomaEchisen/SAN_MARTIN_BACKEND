package com.san.martin.models.services;

import java.util.List;

import com.san.martin.models.entity.Idioma;
import com.san.martin.models.entity.Persona;

public interface IIdiomaService {
	
	public List<Idioma> findAll();
	public Idioma findById(Long id);
	public Idioma saveIdioma(Idioma idioma);
	public void deleteidiomaById(Long id);

}
