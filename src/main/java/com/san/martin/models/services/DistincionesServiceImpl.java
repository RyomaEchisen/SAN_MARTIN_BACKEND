package com.san.martin.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.san.martin.models.dao.IDistincionesDao;
import com.san.martin.models.entity.Distinciones;

@Service
public class DistincionesServiceImpl implements IDistincionesService{
	
	@Autowired
	private IDistincionesDao distincionesDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Distinciones> findAll(){
	
		return (List<Distinciones>) distincionesDao.findAll();
}

	@Override
	@Transactional(readOnly = true)
	public Distinciones findById(Long id) {
		return distincionesDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Distinciones save(Distinciones distinciones) {
		return distincionesDao.save(distinciones);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		distincionesDao.deleteById(id);
	}

}
