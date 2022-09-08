package com.san.martin.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.san.martin.models.dao.IIdiomaDao;
import com.san.martin.models.entity.Idioma;

@Service
public class IdiomaServiceImpl implements IIdiomaService{
	
	@Autowired
	private IIdiomaDao idiomaDao;
	
	@Override
	
	@Transactional(readOnly = true)
	public List<Idioma> findAll(){
	
		return (List<Idioma>) idiomaDao.findAll();
	}
	

}
