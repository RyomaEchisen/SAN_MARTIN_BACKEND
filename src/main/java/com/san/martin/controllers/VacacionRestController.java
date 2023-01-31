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
import com.san.martin.models.entity.Vacaciones;
import com.san.martin.models.services.IVacacionService;

@RestController
@RequestMapping("/api_vacacion")
public class VacacionRestController {
	
	@Autowired
	private IVacacionService eventoService;

	@GetMapping("/vacacionesuser/{id}")
	public List<Vacaciones> listuser(@PathVariable Long id) {
		return eventoService.findByUserId(id);
	}
	
	@GetMapping("/vacacionesgestion/{id}/{gestion}")
	public Vacaciones listusergestion(@PathVariable Long id, @PathVariable String gestion) {
		return eventoService.findByUserIdGestion(id, ""+gestion);
	}
	
	@GetMapping("/vacaciones")
	public List<Vacaciones> index(){
		return eventoService.findAll();
	}
	

	//mostrar por id	
	@GetMapping("/vacaciones/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {
		
		Vacaciones evento = null;
		
		Map<String, Object> response = new HashMap<>();
		
		try {
			evento = eventoService.findById(id);
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
				
		if(evento == null) {
			response.put("mensaje", "El Evento id: ".concat(id.toString().concat(" --no existe ne la base de datos ")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Vacaciones>(evento, HttpStatus.OK);
	}
	
	//crear
	@PostMapping("/vacaciones")
	public ResponseEntity<?> create(@RequestBody Vacaciones evento) {
		
		Vacaciones eventoNew = null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			eventoNew = eventoService.save(evento);
		}catch(DataAccessException e) {
			
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		response.put("mensaje:", "Evento creado correctamente");
		response.put("evento", eventoNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	
	}
	
	//actualizar
	@PutMapping("/vacaciones/{id}")
	public ResponseEntity<?> update(@RequestBody Vacaciones evento, @PathVariable Long id) {
		
		Vacaciones eventoActual = eventoService.findById(id);
		
		Vacaciones eventoUpdated = null;
		
		Map<String, Object> response = new HashMap<>();
		if(eventoActual == null) {
			response.put("mensaje", "Error: no se puede editar el evento Id: ".concat(id.toString().concat("no existe en la base de datos! ")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		try {
			//eventoActual.setTipo(evento.getTipo());
			eventoActual.setCantidadDias(evento.getCantidadDias());
			
			
			eventoUpdated = eventoService.save(eventoActual);
		
		}catch(DataAccessException e) {
			
			response.put("mensaje", "Error al actualizar en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		response.put("mensaje", "El catalogo ha sido actualizado con exito");
		response.put("evento", eventoUpdated);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	//delete
	@DeleteMapping("/vacaciones/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		
		Map<String, Object> response = new HashMap<>();
		try {
			eventoService.delete(id);
		}catch(DataAccessException e) {
			
			response.put("mensaje", "Error al eliminar evento en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "Evento eliminado con exito");
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
}
