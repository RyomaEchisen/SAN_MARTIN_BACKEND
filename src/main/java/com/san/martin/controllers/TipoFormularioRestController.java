package com.san.martin.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.san.martin.models.entity.TipoFormulario;
import com.san.martin.models.services.ITipoFormularioService;

@RestController
@RequestMapping("/api_tipoFormulario")
public class TipoFormularioRestController {

	@Autowired
	private ITipoFormularioService tipoFormularioService;
	
	@GetMapping("/tipoFormularios")
	public List<TipoFormulario> index(){
		return tipoFormularioService.findAll();
	}
}
