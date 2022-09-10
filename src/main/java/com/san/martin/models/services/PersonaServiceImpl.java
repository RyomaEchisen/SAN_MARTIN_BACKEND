package com.san.martin.models.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.san.martin.models.dao.IPersonaDao;
import com.san.martin.models.entity.Persona;

@Service
//1.1 agregar metodos
public class PersonaServiceImpl implements IPersonaService{
	
	@Autowired
	private IPersonaDao personaDao;
	@Override
	//1.2 copiar el transactional lectura
	@Transactional(readOnly = true)
	public List<Persona> findAll(){ //es para accedes a la lista de personas
		return (List<Persona>) personaDao.findAll(); //retorna un iterable, por lo tanto tenemos un list
	}
	@Override
	@Transactional (readOnly = true)
	public Persona findById(Long id) {
	//1.4
		return personaDao.findById(id).orElse(null);
	}
	@Override
	//1.2 transactional completo
	@Transactional
	public Persona savePersona(Persona persona) {
		// TODO Auto-generated method stub
		return personaDao.save(persona);
	}
	//1.3 transactionalcompleto
	@Override
	@Transactional
	public void deletepersonaById(Long id) {
		// TODO Auto-generated method stub
		//1.5
	personaDao.deleteById(id);
		

	}
}
