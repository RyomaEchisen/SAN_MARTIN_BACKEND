package com.san.martin.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.san.martin.models.dao.IEventoDao;
import com.san.martin.models.entity.Evento;

@Service
public class EventoServiceImpl implements IEventoService{
	
	@Autowired
	private IEventoDao eventoDao;
	
	@Override
	
	@Transactional(readOnly = true)
	public List<Evento> findAll(){
		
		return(List<Evento>) eventoDao.findAll();
	}

}
