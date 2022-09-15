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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import com.san.martin.models.entity.Referencia;
import com.san.martin.models.services.IReferenciaService;

@RestController
@RequestMapping("/api_referencia")
public class ReferenciaRestController {
	
	@Autowired
	private IReferenciaService referenciaService;
	
	@GetMapping("/referencias")
	public List<Referencia> index(){
		
		return referenciaService.findAll();
	}
	//Crud
	//listar
	@GetMapping("/referencias/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {
		
		Referencia referencia = null;
		Map<String, Object> response = new HashMap<>();
	
		try {
			referencia = referenciaService.findById(id);
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		    
		}
		
		
		if(referencia == null) {
			response.put("mensaje", "Referencia ID: ".concat(id.toString().concat(" --No existe en la base de Datos")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
			
		}
		return new ResponseEntity<Referencia>(referencia, HttpStatus.OK);
		
		
    }
	//crear
	//entity para las restricciones 
	@PostMapping("/referencias")
	public ResponseEntity<?> create(@RequestBody Referencia referencia) {
		
		
		Referencia referenciaNew = null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			referenciaNew = referenciaService.saveReferencia(referencia);
		
		} catch(DataAccessException e) {
			
			response.put("mensaje", "Error al realizar el insert en la base de datos");	
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", " Referencia se creo con Éxito!!");
		response.put("referencia", referenciaNew);
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);
		
	}
    //Editar
	@PutMapping("/referencias/{id}")
	public ResponseEntity<?>  update(@RequestBody Referencia referencia, @PathVariable Long id ){
		Referencia referenciaActual= referenciaService.findById(id);
	    Referencia referenciaUpdated = null;
	     
	     Map<String, Object> response = new HashMap<>();
	     if(referenciaActual == null) {
				response.put("mensaje", "Error: no se puede editar, Referencia ID: ".concat(id.toString().concat(" --No existe en la base de Datos")));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
				
				
			}
	     
	     try {
	     referenciaActual.setNombreCompleto(referencia.getNombreCompleto());
	     referenciaActual.setInstitucion(referencia.getInstitucion());
	     referenciaActual.setCargo(referencia.getCargo());
	     referenciaActual.setTelfRef(referencia.getTelfRef());
	     

	     referenciaUpdated = referenciaService.saveReferencia(referenciaActual);
	     } catch(DataAccessException e) {
			
			response.put("mensaje", "Error al Actualizar Referencia en la base de datos");	
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	     
	     response.put("mensaje", "Referencia actualizada con Éxito!!");
		 response.put("referencia", referenciaUpdated);
	     return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);
	     
	     }
	
	 @DeleteMapping("/referencias/{id}")
	     @ResponseStatus(HttpStatus.NO_CONTENT)
	     public ResponseEntity<?> delete(@PathVariable Long id) {
		 Map<String, Object> response = new HashMap<>();
		 
		 
		  try {
	     
			  referenciaService.deletereferenciaById(id);
		  } catch(DataAccessException e) {
				
				response.put("mensaje", "Error al Eliminar Referencia en la base de datos");	
				response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		  response.put("mensaje", "Referencia eliminada con éxito!");		
		  return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

	 	}
}
