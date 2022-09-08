package com.san.martin.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.san.martin.models.entity.Conocimiento;
import com.san.martin.models.services.IConocimientoService;

@RestController
@RequestMapping("/api_conocimiento")
public class ConocimientoRestController {
	
	@Autowired
	private IConocimientoService conocimientoService;
	
	@GetMapping("/conocimientos")
	public List<Conocimiento> index(){
		
		return conocimientoService.findAll();
	}
	
}
