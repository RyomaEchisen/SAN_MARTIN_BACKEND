package com.san.martin.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.san.martin.models.dao.IFormularioDao;
import com.san.martin.models.entity.Formulario;

@Service
public class FormularioServiceImpl implements IFormularioService{
	
	@Autowired
	private IFormularioDao formularioDao;
	
	@Override
	
	@Transactional(readOnly = true)
	public List<Formulario> findAll(){
		return (List<Formulario>) formularioDao.findAll();
	}
	
}
