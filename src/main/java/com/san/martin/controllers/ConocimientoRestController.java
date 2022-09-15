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
	//mostrar por id
	@GetMapping("/conocimientos/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {
		
		Conocimiento conocimiento = null;
		
		Map<String, Object> response = new HashMap<>();
		
		try {
			conocimiento = conocimientoService.findById(id);
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
				
		if(conocimiento == null) {
			response.put("mensaje", "El Conocimiento id: ".concat(id.toString().concat(" --no existe ne la base de datos ")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Conocimiento>(conocimiento, HttpStatus.OK);
	}
		
	//crear
	@PostMapping("/conocimientos")
	public ResponseEntity<?> create(@RequestBody Conocimiento conocimiento) {
		
		Conocimiento conocimientoNew = null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			conocimientoNew = conocimientoService.save(conocimiento);
		}catch(DataAccessException e) {
			
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		response.put("mensaje:", "Conocimiento creado correctamente");
		response.put("conocimiento", conocimientoNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	
	}
	
	//actualizar
	@PutMapping("/conocimientos/{id}")
	public ResponseEntity<?> update(@RequestBody Conocimiento conocimiento, @PathVariable Long id) {
		
		Conocimiento conocimientoActual = conocimientoService.findById(id);
		
		Conocimiento conocimientoUpdated = null;
		
		Map<String, Object> response = new HashMap<>();
		if(conocimientoActual == null) {
			response.put("mensaje", "Error: no se puede editar el archivo Id: ".concat(id.toString().concat("no existe en la base de datos! ")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		try {
			conocimientoActual.setNombre(conocimiento.getNombre());
			conocimientoActual.setNivel(conocimiento.getNivel());
			conocimientoActual.setTipo(conocimiento.getTipo());
			
			conocimientoUpdated = conocimientoService.save(conocimientoActual);
		
		}catch(DataAccessException e) {
			
			response.put("mensaje", "Error al actualizar en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		response.put("mensaje", "El catalogo ha sido actualizado con exito");
		response.put("conocimiento", conocimientoUpdated);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	//delete
	@DeleteMapping("/conocimientos/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		
		Map<String, Object> response = new HashMap<>();
		try {
			conocimientoService.delete(id);
		}catch(DataAccessException e) {
			
			response.put("mensaje", "Error al eliminar catalogo en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "Conocimiento eliminado con exito");
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
		
}
