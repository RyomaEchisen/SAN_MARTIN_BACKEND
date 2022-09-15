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

import com.san.martin.models.entity.Idioma;
import com.san.martin.models.services.IIdiomaService;

@RestController
@RequestMapping("/api_idioma")
public class IdiomaRestController {
	
	@Autowired
	private IIdiomaService idiomaService;
	
	@GetMapping("/idiomas")
	public List<Idioma> index(){
		return idiomaService.findAll();
	}
	
	//mostrar por id
		@GetMapping("/idiomas/{id}")
		public ResponseEntity<?> show(@PathVariable Long id) {
			
			Idioma idioma = null;
			
			Map<String, Object> response = new HashMap<>();
			
			try {
				idioma = idiomaService.findById(id);
			} catch(DataAccessException e) {
				response.put("mensaje", "Error al realizar la consulta en la base de datos");
				response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
					
			if(idioma == null) {
				response.put("mensaje", "El idioma id: ".concat(id.toString().concat(" --no existe ne la base de datos ")));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<Idioma>(idioma, HttpStatus.OK);
		}
		
		//crear
		@PostMapping("/idiomas")
		public ResponseEntity<?> create(@RequestBody Idioma idioma) {
			
			Idioma idiomaNew = null;
			Map<String, Object> response = new HashMap<>();
			
			try {
				idiomaNew = idiomaService.saveIdioma(idioma);
			}catch(DataAccessException e) {
				
				response.put("mensaje", "Error al realizar el insert en la base de datos");
				response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
				
			}
			response.put("mensaje:", "Idioma creado correctamente");
			response.put("idioma", idiomaNew);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
		
		}
		
		
		//actualizar
		@PutMapping("/idiomas/{id}")  
		public ResponseEntity<?> update(@RequestBody Idioma idioma, @PathVariable Long id) {
			
			Idioma idiomaActual = idiomaService.findById(id);
			
			Idioma idiomaUpdated = null;
			
			Map<String, Object> response = new HashMap<>();
			if(idiomaActual == null) {
				response.put("mensaje", "Error: no se puede editar el idioma Id: ".concat(id.toString().concat("no existe en la base de datos! ")));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
			}
			try {
				idiomaActual.setNombre(idioma.getNombre());
				idiomaActual.setHabla(idioma.getHabla());
				idiomaActual.setLee(idioma.getLee());
				idiomaActual.setEscribe(idioma.getEscribe());
				
				
				idiomaUpdated = idiomaService.saveIdioma(idiomaActual);
			
			}catch(DataAccessException e) {
				
				response.put("mensaje", "Error al actualizar en la base de datos");
				response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
				
			}
			response.put("mensaje", "El idioma ha sido actualizado con exito");
			response.put("Idioma", idiomaUpdated);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
		}

		//delete 
		@DeleteMapping("/archivos/{id}")
		public ResponseEntity<?> delete(@PathVariable Long id) {
			
			Map<String, Object> response = new HashMap<>();
			try {
				idiomaService.deleteidiomaById(id);
			}catch(DataAccessException e) {
				
				response.put("mensaje", "Error al eliminar idioma en la base de datos");
				response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			response.put("mensaje", "Idioma eliminado con exito");
			
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		}
}
