package com.san.martin.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.san.martin.models.dao.IFormacionAcademicaDao;
import com.san.martin.models.entity.FormacionAcademica;

@Service
public class FormacionAcademicaServiceImpl implements IFormacionAcademicaService{
	
	@Autowired
	private IFormacionAcademicaDao formacionAcademicaDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<FormacionAcademica> findAll(){
		
		return(List<FormacionAcademica>) formacionAcademicaDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public FormacionAcademica findById(Long id) {
		return formacionAcademicaDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public FormacionAcademica save(FormacionAcademica formacionAcademica) {
		return formacionAcademicaDao.save(formacionAcademica);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		formacionAcademicaDao.deleteById(id);
	}
	

}
