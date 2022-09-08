package com.san.martin.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.san.martin.models.entity.Cursos;
import com.san.martin.models.services.ICursosService;

@RestController
@RequestMapping("/api_cursos")
public class CursosRestController {
	
	@Autowired
	private ICursosService cursosService;
	
	@GetMapping("/cursos")
	public List<Cursos> index(){
		
		return cursosService.findAll();
		
	}

}
