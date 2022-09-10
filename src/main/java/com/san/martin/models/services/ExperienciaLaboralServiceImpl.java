package com.san.martin.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.san.martin.models.dao.IExperienciaLaboralDao;
import com.san.martin.models.entity.ExperienciaLaboral;

@Service
public class ExperienciaLaboralServiceImpl implements IExperienciaLaboralService{
	
	@Autowired
	private IExperienciaLaboralDao experienciaLaboralDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<ExperienciaLaboral> findAll(){
		
		return (List<ExperienciaLaboral>) experienciaLaboralDao.findAll();
	
	}

	@Override
	@Transactional(readOnly = true)
	public ExperienciaLaboral findById(Long id) {
		return experienciaLaboralDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public ExperienciaLaboral save(ExperienciaLaboral experienciaLaboral) {
		return experienciaLaboralDao.save(experienciaLaboral);
	}

	@Override
	public void delete(Long id) {
		experienciaLaboralDao.deleteById(id);
	}

}
