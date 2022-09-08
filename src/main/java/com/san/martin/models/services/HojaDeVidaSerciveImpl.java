package com.san.martin.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.san.martin.models.dao.IHojaDeVidaDao;
import com.san.martin.models.entity.HojaDeVida;

@Service
public class HojaDeVidaSerciveImpl implements IHojaDeVidaService{
	
	@Autowired
	private IHojaDeVidaDao hojaDeVidaDao;
	
	@Override
	
	@Transactional(readOnly = true)
	public List<HojaDeVida> findAll() {
		
		return (List<HojaDeVida>) hojaDeVidaDao.findAll();
	}
	
	
}
