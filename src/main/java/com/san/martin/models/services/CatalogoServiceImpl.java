package com.san.martin.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.san.martin.models.dao.ICatalogoDao;
import com.san.martin.models.entity.Catalogo;

@Service
public class CatalogoServiceImpl implements ICatalogoService{
	
	@Autowired
	private ICatalogoDao catalogoDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Catalogo> findAll(){
		
		return(List<Catalogo>) catalogoDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Catalogo findById(Long id) {
		return catalogoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Catalogo save(Catalogo catalogo) {
		return catalogoDao.save(catalogo);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		catalogoDao.deleteById(id);
	}

}
