package com.san.martin.models.services;

import java.util.List;

import com.san.martin.models.entity.ExperienciaLaboral;

public interface IExperienciaLaboralService {

	public List<ExperienciaLaboral> findAll();
	
	public ExperienciaLaboral findById(Long id);
	
	public ExperienciaLaboral save (ExperienciaLaboral experienciaLaboral);
	
	public void delete (Long id);
}
