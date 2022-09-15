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

import com.san.martin.models.entity.ExperienciaLaboral;
import com.san.martin.models.services.IExperienciaLaboralService;

@RestController
@RequestMapping("/api_experienciaLaboral")
public class ExperienciaLaboralRestController {

	@Autowired
	private IExperienciaLaboralService experienciaLaboralService;
	
	@GetMapping("/experienciaLaborales")
	public List<ExperienciaLaboral> index(){
		return experienciaLaboralService.findAll();
	}
	
	//mostrar por id	
	@GetMapping("/experienciaLaborales/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {
		
		ExperienciaLaboral experienciaLaboral = null;
		
		Map<String, Object> response = new HashMap<>();
		
		try {
			experienciaLaboral = experienciaLaboralService.findById(id);
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
				
		if(experienciaLaboral == null) {
			response.put("mensaje", "El experienciaLaboral id: ".concat(id.toString().concat(" --no existe ne la base de datos ")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<ExperienciaLaboral>(experienciaLaboral, HttpStatus.OK);
	}
		
	//crear
	@PostMapping("/experienciaLaborales")
	public ResponseEntity<?> create(@RequestBody ExperienciaLaboral experienciaLaboral) {
		
		ExperienciaLaboral experienciaLaboralNew = null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			experienciaLaboralNew = experienciaLaboralService.save(experienciaLaboral);
		}catch(DataAccessException e) {
			
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		response.put("mensaje:", "ExperienciaLaboral creado correctamente");
		response.put("experienciaLaboral", experienciaLaboralNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	
	}
	
	//actualizar	
	@PutMapping("/experienciaLaborales/{id}")
	public ResponseEntity<?> update(@RequestBody ExperienciaLaboral experienciaLaboral, @PathVariable Long id) {
		
		ExperienciaLaboral experienciaLaboralActual = experienciaLaboralService.findById(id);
		
		ExperienciaLaboral experienciaLaboralUpdated = null;
		
		Map<String, Object> response = new HashMap<>();
		if(experienciaLaboralActual == null) {
			response.put("mensaje", "Error: no se puede editar la experienciaLaboral Id: ".concat(id.toString().concat("no existe en la base de datos! ")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		try {
			experienciaLaboralActual.setInstitucion(experienciaLaboral.getInstitucion());
			experienciaLaboralActual.setTipo(experienciaLaboral.getTipo());
			experienciaLaboralActual.setDuracion(experienciaLaboral.getDuracion());
			experienciaLaboralActual.setCargo(experienciaLaboral.getCargo());
			experienciaLaboralActual.setFechaInicio(experienciaLaboral.getFechaInicio());
			experienciaLaboralActual.setFechaFin(experienciaLaboral.getFechaFin());
			experienciaLaboralActual.setMotivoFinalizacion(experienciaLaboral.getMotivoFinalizacion());
			
			experienciaLaboralUpdated = experienciaLaboralService.save(experienciaLaboralActual);
		
		}catch(DataAccessException e) {
			
			response.put("mensaje", "Error al actualizar en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		response.put("mensaje", "El catalogo ha sido actualizado con exito");
		response.put("experienciaLaboral", experienciaLaboralUpdated);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	//delete	
	@DeleteMapping("/experienciaLaborales/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		
		Map<String, Object> response = new HashMap<>();
		try {
			experienciaLaboralService.delete(id);
		}catch(DataAccessException e) {
			
			response.put("mensaje", "Error al eliminar experienciaLaboral en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "ExperienciaLaboral eliminado con exito");
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
}
