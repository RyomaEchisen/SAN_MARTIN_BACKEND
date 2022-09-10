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
	@Transactional(readOnly = true)
	@Override
	public Formulario findById(Long id) {
		// TODO Auto-generated method stub
		return formularioDao.findById(id).orElse(null);
	}
	@Transactional
	@Override
	public Formulario saveFormulario(Formulario formulario) {
		// TODO Auto-generated method stub
		return formularioDao.save(formulario);
	}
	@Transactional
	@Override
	public void deleteformularioById(Long id) {
		// TODO Auto-generated method stub
		formularioDao.deleteById(id);
		
	}
	
}
