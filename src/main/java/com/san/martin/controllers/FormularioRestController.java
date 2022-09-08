package com.san.martin.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.san.martin.models.entity.Formulario;
import com.san.martin.models.services.IFormularioService;

@RestController
@RequestMapping("/api_formulario")
public class FormularioRestController {
	
	@Autowired
	private IFormularioService formularioService;
	
	@GetMapping("/formularios")
	public List<Formulario> index(){
		return formularioService.findAll();
	}

}
