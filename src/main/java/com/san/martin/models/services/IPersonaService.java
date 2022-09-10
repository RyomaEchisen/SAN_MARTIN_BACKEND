package com.san.martin.models.services;

import java.util.List;


import com.san.martin.models.entity.Persona;

public interface IPersonaService {
	//1-implementar el contrato
	public List<Persona> findAll();
	public Persona findById(Long id);
	public Persona savePersona(Persona persona);
	public void deletepersonaById(Long id);
	
}















