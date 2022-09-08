package com.san.martin.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.san.martin.models.dao.ICursosDao;
import com.san.martin.models.entity.Cursos;

@Service
public class CursosServiceImpl implements ICursosService{
	
	@Autowired
	private ICursosDao cursosDao;
	
	@Override
	
	@Transactional(readOnly = true)
	public List<Cursos> findAll(){
		
		return(List<Cursos>) cursosDao.findAll();
	}

}
