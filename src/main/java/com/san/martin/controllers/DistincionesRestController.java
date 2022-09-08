package com.san.martin.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.san.martin.models.entity.Distinciones;
import com.san.martin.models.services.IDistincionesService;

@RestController
@RequestMapping("/api_distincion")
public class DistincionesRestController {
	
	@Autowired
	private IDistincionesService distincionesService;
	
	@GetMapping("/distinciones")
	public List<Distinciones> index(){
		return distincionesService.findAll();
	}

}
