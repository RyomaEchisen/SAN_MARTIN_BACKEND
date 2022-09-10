package com.san.martin.models.services;

import java.util.List;

import com.san.martin.models.entity.FormacionAcademica;

public interface IFormacionAcademicaService {
	
	public List<FormacionAcademica> findAll();
	
	public FormacionAcademica findById(Long id);
	
	public FormacionAcademica save (FormacionAcademica formacionAcademica);
	
	public void delete(Long id);

}
