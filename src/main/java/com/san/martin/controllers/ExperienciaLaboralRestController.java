package com.san.martin.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.san.martin.models.entity.ExperienciaLaboral;
import com.san.martin.models.services.IExperienciaLaboralService;

@RestController
@RequestMapping("/api_experienciaLaboral")
public class ExperienciaLaboralRestController {

	@Autowired
	private IExperienciaLaboralService experienciaLaboralService;
	
	@GetMapping("/usuarios")
	public List<ExperienciaLaboral> index(){
		
		return experienciaLaboralService.findAll();
	}
}
