package com.san.martin.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.san.martin.models.entity.HojaDeVida;
import com.san.martin.models.services.IHojaDeVidaService;

@RestController
@RequestMapping("/api_hojaDeVida")
public class HojaDeVidaRestController {
	
	@Autowired
	private IHojaDeVidaService hojaDeVidaService;
	
	@GetMapping("/hojaDeVidas")
	public List<HojaDeVida> index(){
		return hojaDeVidaService.findAll();
	}

}
