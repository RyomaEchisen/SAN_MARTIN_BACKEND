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

	@Override
	@Transactional(readOnly = true)
	public Cursos findById(Long id) {
		return cursosDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Cursos save(Cursos cursos) {
		return cursosDao.save(cursos);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		cursosDao.deleteById(id);
	}

}
