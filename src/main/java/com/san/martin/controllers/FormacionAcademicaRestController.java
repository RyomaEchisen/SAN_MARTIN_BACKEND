package com.san.martin.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.san.martin.models.entity.FormacionAcademica;
import com.san.martin.models.services.IFormacionAcademicaService;

@RestController
@RequestMapping("/api_formacionAcademica")
public class FormacionAcademicaRestController {
	
	@Autowired
	private IFormacionAcademicaService formacionAcademicaService;
	
	@GetMapping("/usuarios")
	public List<FormacionAcademica> index(){
		
		return formacionAcademicaService.findAll();
	}

}
