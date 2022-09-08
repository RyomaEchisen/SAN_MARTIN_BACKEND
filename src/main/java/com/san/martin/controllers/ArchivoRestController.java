package com.san.martin.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.san.martin.models.entity.Archivo;
import com.san.martin.models.services.IArchivoService;

@RestController
@RequestMapping("/api_archivo")
public class ArchivoRestController {
	
	@Autowired
	private IArchivoService archivoService;
	
	@GetMapping("/usuarios")
	public List<Archivo> index(){
		
		return archivoService.findAll();
	}
}
