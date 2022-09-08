package com.san.martin.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.san.martin.models.entity.Sucursal;
import com.san.martin.models.services.ISucursalService;

@RestController
@RequestMapping("/api_sucursal")
public class SucursalRestController {
	
	@Autowired
	private ISucursalService sucursalService;
	
	@GetMapping("/sucursales")
	public List<Sucursal> index(){
		return sucursalService.findAll();
	}

}
