package com.san.martin.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.san.martin.models.entity.Referencia;
import com.san.martin.models.services.IReferenciaService;

@RestController
@RequestMapping("/api_referencia")
public class ReferenciaRestController {
	
	@Autowired
	private IReferenciaService referenciaService;
	
	@GetMapping("/referencias")
	public List<Referencia> index(){
		
		return referenciaService.findAll();
	}

}
