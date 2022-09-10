package com.san.martin.models.services;

import java.util.List;

import com.san.martin.models.entity.Catalogo;

public interface ICatalogoService {
	
	public List<Catalogo> findAll();
	
	public Catalogo findById(Long id);
	
	public Catalogo save(Catalogo catalogo);
	
	public void delete(Long id);

}
