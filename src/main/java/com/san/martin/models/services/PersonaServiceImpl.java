package com.san.martin.models.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.san.martin.models.dao.IPersonaDao;
import com.san.martin.models.entity.persona;

@Service
public class PersonaServiceImpl implements IPersonaService{
	
	@Autowired
	private IPersonaDao personaDao;
	@Override
	@Transactional (readOnly = true)
	public List<persona> findAll(){ //es para accedes a la lista de personas
		return (List<persona>) personaDao.findAll(); //retorna un iterable, por lo tanto tenemos un list
	}
}