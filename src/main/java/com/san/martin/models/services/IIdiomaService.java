package com.san.martin.models.services;

import java.util.List;

import com.san.martin.models.entity.Idioma;


public interface IIdiomaService {
	
	public List<Idioma> findAll();
	public Idioma findById(Long id);
	public Idioma saveIdioma(Idioma idioma);
	public void deleteidiomaById(Long id);

}
