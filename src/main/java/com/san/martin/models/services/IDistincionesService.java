package com.san.martin.models.services;

import java.util.List;

import com.san.martin.models.entity.Distinciones;

public interface IDistincionesService {
	
	public List<Distinciones> findAll();
	
	public Distinciones findById(Long id);
	
	public Distinciones save (Distinciones distinciones);
	
	public void delete(Long id);

}
