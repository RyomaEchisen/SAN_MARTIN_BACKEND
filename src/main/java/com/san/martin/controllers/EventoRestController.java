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

import com.san.martin.models.entity.Evento;
import com.san.martin.models.services.IEventoService;

@RestController
@RequestMapping("/api_evento")
public class EventoRestController {
	
	@Autowired
	private IEventoService eventoService;
	
	@GetMapping("/eventos")
	public List<Evento> index(){
		return eventoService.findAll();
	}
	

	//mostrar por id	
	@GetMapping("/eventos/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {
		
		Evento evento = null;
		
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
		return new ResponseEntity<Evento>(evento, HttpStatus.OK);
	}
	
	//crear
	@PostMapping("/eventos")
	public ResponseEntity<?> create(@RequestBody Evento evento) {
		
		Evento eventoNew = null;
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
	@PutMapping("/eventos/{id}")
	public ResponseEntity<?> update(@RequestBody Evento evento, @PathVariable Long id) {
		
		Evento eventoActual = eventoService.findById(id);
		
		Evento eventoUpdated = null;
		
		Map<String, Object> response = new HashMap<>();
		if(eventoActual == null) {
			response.put("mensaje", "Error: no se puede editar el evento Id: ".concat(id.toString().concat("no existe en la base de datos! ")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		try {
			eventoActual.setTipo(evento.getTipo());
			eventoActual.setTabla(evento.getTabla());
			eventoActual.setIdRegistro(evento.getIdRegistro());
			eventoActual.setFechaHora(evento.getFechaHora());
			eventoActual.setEstadoAnterios(evento.getEstadoAnterios());
			
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
	@DeleteMapping("/eventos/{id}")
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
