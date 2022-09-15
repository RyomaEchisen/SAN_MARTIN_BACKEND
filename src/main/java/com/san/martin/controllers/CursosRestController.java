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

import com.san.martin.models.entity.Cursos;
import com.san.martin.models.services.ICursosService;

@RestController
@RequestMapping("/api_cursos")
public class CursosRestController {
	
	@Autowired
	private ICursosService cursosService;
	
	@GetMapping("/cursos")
	public List<Cursos> index(){
		return cursosService.findAll();	
	}
	
	//mostrar por id
	@GetMapping("/cursos/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {
		
		Cursos cursos = null;
		
		Map<String, Object> response = new HashMap<>();
		
		try {
			cursos = cursosService.findById(id);
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
				
		if(cursos == null) {
			response.put("mensaje", "El cursos id: ".concat(id.toString().concat(" --no existe ne la base de datos ")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Cursos>(cursos, HttpStatus.OK);
	}
	
	//crear
	@PostMapping("/cursos")
	public ResponseEntity<?> create(@RequestBody Cursos cursos) {
		
		Cursos cursosNew = null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			cursosNew = cursosService.save(cursos);
		}catch(DataAccessException e) {
			
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		response.put("mensaje:", "Cursos creado correctamente");
		response.put("cursos", cursosNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	
	}
	
	//actualizar
	@PutMapping("/cursos/{id}")
	public ResponseEntity<?> update(@RequestBody Cursos cursos, @PathVariable Long id) {
		
		Cursos cursosActual = cursosService.findById(id);
		
		Cursos cursosUpdated = null;
		
		Map<String, Object> response = new HashMap<>();
		if(cursosActual == null) {
			response.put("mensaje", "Error: no se puede editar el archivo Id: ".concat(id.toString().concat("no existe en la base de datos! ")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		try {
			cursosActual.setInstitucion(cursos.getInstitucion());
			cursosActual.setNombreCurso(cursos.getNombreCurso());
			cursosActual.setHorasAcademincas(cursos.getHorasAcademincas());
			cursosActual.setNota(cursos.getNota());
			cursosActual.setFecha(cursos.getFecha());
			
			cursosUpdated = cursosService.save(cursosActual);
		
		}catch(DataAccessException e) {
			
			response.put("mensaje", "Error al actualizar en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		response.put("mensaje", "El curso ha sido actualizado con exito");
		response.put("curso", cursosUpdated);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	//delete
	@DeleteMapping("/cursos/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		
		Map<String, Object> response = new HashMap<>();
		try {
			cursosService.delete(id);
		}catch(DataAccessException e) {
			
			response.put("mensaje", "Error al eliminar catalogo en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "Cursos eliminado con exito");
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
}
