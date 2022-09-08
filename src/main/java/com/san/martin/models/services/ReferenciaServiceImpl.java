package com.san.martin.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.san.martin.models.dao.IReferenciaDao;
import com.san.martin.models.entity.Referencia;

@Service
public class ReferenciaServiceImpl implements IReferenciaService{
	
	@Autowired
	private IReferenciaDao referenciaDao;
	
	@Override
	
	@Transactional(readOnly = true)
	public List<Referencia> findAll(){
	
		return (List<Referencia>) referenciaDao.findAll();
}

}
