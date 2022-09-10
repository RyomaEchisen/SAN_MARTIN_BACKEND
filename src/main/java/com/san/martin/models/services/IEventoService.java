package com.san.martin.models.services;

import java.util.List;

import com.san.martin.models.entity.Evento;

public interface IEventoService {
	
	public List<Evento> findAll();
	
	public Evento findById(Long id);
	
	public Evento save (Evento evento);
	
	public void delete(Long id);

}
