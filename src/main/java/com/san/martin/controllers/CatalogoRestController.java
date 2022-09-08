package com.san.martin.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.san.martin.models.entity.Catalogo;
import com.san.martin.models.services.ICatalogoService;

@RestController
@RequestMapping("/api_catalogo")
public class CatalogoRestController {

	@Autowired
	private ICatalogoService catalogoService;
	
	@GetMapping("/catalogos")
	public List<Catalogo> index(){
		
		return catalogoService.findAll();
	}
}
