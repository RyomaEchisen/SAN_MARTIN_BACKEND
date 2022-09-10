package com.san.martin.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.san.martin.models.dao.IArchivoDao;
import com.san.martin.models.entity.Archivo;

@Service
public class ArchivoServiceImpl implements IArchivoService{
	
	@Autowired
	private IArchivoDao archivoDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Archivo> findAll(){
		
		return(List<Archivo>) archivoDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Archivo findById(Long id) {
		return archivoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Archivo save(Archivo archivo) {
		return archivoDao.save(archivo);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		archivoDao.deleteById(id);
	}

	
	

}
