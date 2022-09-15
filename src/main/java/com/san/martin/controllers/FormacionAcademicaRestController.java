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

import com.san.martin.models.entity.FormacionAcademica;
import com.san.martin.models.services.IFormacionAcademicaService;

@RestController
@RequestMapping("/api_formacionAcademica")
public class FormacionAcademicaRestController {

	@Autowired
	private IFormacionAcademicaService formacionAcademicaService;

	@GetMapping("/formacionAcademicas")
	public List<FormacionAcademica> index() {
		return formacionAcademicaService.findAll();
	}

	// mostrar por id
	@GetMapping("/formacionAcademicas/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {
		
		FormacionAcademica formacionAcademica = null;
		
		Map<String, Object> response = new HashMap<>();
		
		try {
			formacionAcademica = formacionAcademicaService.findById(id);
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
				
		if(formacionAcademica == null) {
			response.put("mensaje", "La formacionAcademica id: ".concat(id.toString().concat(" --no existe ne la base de datos ")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<FormacionAcademica>(formacionAcademica, HttpStatus.OK);
	}

	// crear
	@PostMapping("/formacionAcademicas")
	public ResponseEntity<?> create(@RequestBody FormacionAcademica formacionAcademica) {
		
		FormacionAcademica formacionAcademicaNew = null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			formacionAcademicaNew = formacionAcademicaService.save(formacionAcademica);
		}catch(DataAccessException e) {
			
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		response.put("mensaje:", "FormacionAcademica creado correctamente");
		response.put("formacionAcademica", formacionAcademicaNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	
	}

	// actualizar
	@PutMapping("/formacionAcademicas/{id}")
	public ResponseEntity<?> update(@RequestBody FormacionAcademica formacionAcademica, @PathVariable Long id) {
		
		FormacionAcademica formacionAcademicaActual = formacionAcademicaService.findById(id);
		
		FormacionAcademica formacionAcademicaUpdated = null;
		
		Map<String, Object> response = new HashMap<>();
		if(formacionAcademicaActual == null) {
			response.put("mensaje", "Error: no se puede editar el archivo Id: ".concat(id.toString().concat("no existe en la base de datos! ")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		try {
			formacionAcademicaActual.setNombre(formacionAcademica.getNombre());
			formacionAcademicaActual.setModalidad(formacionAcademica.getModalidad());
			formacionAcademicaActual.setNivel(formacionAcademica.getNivel());
			formacionAcademicaActual.setTerminado(formacionAcademica.isTerminado());
			formacionAcademicaActual.setFechaInicio(formacionAcademica.getFechaInicio());
			formacionAcademicaActual.setFechaFin(formacionAcademica.getFechaFin());
			
			formacionAcademicaUpdated = formacionAcademicaService.save(formacionAcademicaActual);
		
		}catch(DataAccessException e) {
			
			response.put("mensaje", "Error al actualizar en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		response.put("mensaje", "El formacionAcademica ha sido actualizado con exito");
		response.put("formacionAcademica", formacionAcademicaUpdated);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	// delete
	@DeleteMapping("/formacionAcademicas/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		
		Map<String, Object> response = new HashMap<>();
		try {
			formacionAcademicaService.delete(id);
		}catch(DataAccessException e) {
			
			response.put("mensaje", "Error al eliminar formacionAcademica en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "FormacionAcademica eliminado con exito");
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

}
