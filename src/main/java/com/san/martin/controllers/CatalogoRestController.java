package com.san.martin.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	//mostrar por id
	@GetMapping("/catalogos/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {
		
		Catalogo catalogo = null;
		
		Map<String, Object> response = new HashMap<>();
		
		try {
			catalogo = catalogoService.findById(id);
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
				
		if(catalogo == null) {
			response.put("mensaje", "El catalogo id: ".concat(id.toString().concat(" --no existe ne la base de datos ")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Catalogo>(catalogo, HttpStatus.OK);
	}

		
	//crear
	@PostMapping("/catalogos")
	public ResponseEntity<?> create(@RequestBody Catalogo catalogo) {
		
		Catalogo catalogoNew = null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			catalogoNew = catalogoService.save(catalogo);
		}catch(DataAccessException e) {
			
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		response.put("mensaje:", "Catalogo creado correctamente");
		response.put("catalogo", catalogoNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	
	}
	
	
	//actualizar
	@PutMapping("/catalogos/{id}")
	public ResponseEntity<?> update(@RequestBody Catalogo catalogo, @PathVariable Long id) {
		
		Catalogo catalogoActual = catalogoService.findById(id);
		
		Catalogo catalogoUpdated = null;
		
		Map<String, Object> response = new HashMap<>();
		if(catalogoActual == null) {
			response.put("mensaje", "Error: no se puede editar el archivo Id: ".concat(id.toString().concat("no existe en la base de datos! ")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		try {
			catalogoActual.setAbreviacion(catalogo.getAbreviacion());
			catalogoActual.setNombre(catalogo.getNombre());
			catalogoActual.setTipo(catalogo.getTipo());
			
			catalogoUpdated = catalogoService.save(catalogoActual);
		
		}catch(DataAccessException e) {
			
			response.put("mensaje", "Error al actualizar en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		response.put("mensaje", "El catalogo ha sido actualizado con exito");
		response.put("catalogo", catalogoUpdated);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	
	//delete
	@DeleteMapping("/catalogos/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		
		Map<String, Object> response = new HashMap<>();
		try {
			catalogoService.delete(id);
		}catch(DataAccessException e) {
			
			response.put("mensaje", "Error al eliminar catalogo en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "Catalogo eliminado con exito");
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	
}
