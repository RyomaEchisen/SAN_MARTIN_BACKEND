package com.san.martin.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.san.martin.models.entity.persona;
import com.san.martin.models.services.IPersonaService;

@RestController
@RequestMapping("/api")
public class PersonaRestController {
	
	@Autowired
	private IPersonaService personaService;
	
	@GetMapping("/personas")
	public List<persona> index(){
		return personaService.findAll();
	}
}





