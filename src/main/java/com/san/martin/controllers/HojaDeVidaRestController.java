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

import com.san.martin.models.entity.HojaDeVida;
import com.san.martin.models.services.IHojaDeVidaService;

@RestController
@RequestMapping("/api_hojaDeVida")
public class HojaDeVidaRestController {
	
	@Autowired
	private IHojaDeVidaService hojaDeVidaService;
	
	@GetMapping("/hojaDeVidas")
	public List<HojaDeVida> index(){
		return hojaDeVidaService.findAll();
	}
	//Crud
	
		//listar
		@GetMapping("/hojaDeVidas/{id}")
		public ResponseEntity<?> show(@PathVariable Long id) {
			
			HojaDeVida hojaDeVida = null;
			Map<String, Object> response = new HashMap<>();
		
			try {
				hojaDeVida = hojaDeVidaService.findById(id);
			} catch(DataAccessException e) {
				response.put("mensaje", "Error al realizar la consulta en la base de datos");
				response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			    
			}
			
			
			if(hojaDeVida == null) {
				response.put("mensaje", "Hoja de Vida ID: ".concat(id.toString().concat(" --No existe en la base de Datos")));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
				
			}
			return new ResponseEntity<HojaDeVida>(hojaDeVida, HttpStatus.OK);
			
	    }
		//crear
		//entity para las restricciones 
		@PostMapping("/hojaDeVidas")
		public ResponseEntity<?> create(@RequestBody HojaDeVida hojaDeVida) {
			
			
			HojaDeVida hojaDeVidaNew = null;
			Map<String, Object> response = new HashMap<>();
			try {
				hojaDeVidaNew = hojaDeVidaService.saveHojaDeVida(hojaDeVida);
			
			} catch(DataAccessException e) {
				
				response.put("mensaje", "Error al realizar el insert en la base de datos");	
				response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			response.put("mensaje", "Hoja de Vida ha sido creado con Éxito!!");
			response.put("hojaDeVida", hojaDeVidaNew);
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);
			
		}
	    //Editar
		@PutMapping("/hojaDeVidas/{id}")
		public ResponseEntity<?>  update(@RequestBody HojaDeVida hojaDeVida, @PathVariable Long id ){
			HojaDeVida hojaDeVidaActual= hojaDeVidaService.findById(id);
		     
			HojaDeVida hojaDeVidaUpdated = null;
		     
		     Map<String, Object> response = new HashMap<>();
		     if(hojaDeVidaActual == null) {
					response.put("mensaje", "Error: no se puede editar, Hoja de Vida ID: ".concat(id.toString().concat(" --No existe en la base de Datos")));
					return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
					
					
				}
		     
		     try {
		    	 hojaDeVidaActual.setLugarDeResidencia(hojaDeVida.getLugarDeResidencia());
		    	 hojaDeVidaActual.setPerfilProfecional(hojaDeVida.getPerfilProfecional());
		    	 hojaDeVidaActual.setColegioProfecional(hojaDeVida.getColegioProfecional());
		    	 hojaDeVidaActual.setNumRegistroColegio(hojaDeVida.getNumRegistroColegio());
		    	 hojaDeVidaActual.setInformacion(hojaDeVida.getInformacion());
		  
		     
		     hojaDeVidaUpdated = hojaDeVidaService.saveHojaDeVida(hojaDeVidaActual);
		     } catch(DataAccessException e) {
				
				response.put("mensaje", "Error al Actualizar Hoja de Vida en la base de datos");	
				response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		     
		     response.put("mensaje", "La Persona ha sido actualizada con Éxito!!");
			 response.put("hojaDeVida", hojaDeVidaUpdated);
		     return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);
		     
		     }
		
		 @DeleteMapping("/hojaDeVidas/{id}")
		     @ResponseStatus(HttpStatus.NO_CONTENT)
		     public ResponseEntity<?> delete(@PathVariable Long id) {
			 Map<String, Object> response = new HashMap<>();
			 
			  try {
		     
				  hojaDeVidaService.deletehojaDeVidaById(id);
			  } catch(DataAccessException e) {
					
					response.put("mensaje", "Error al Eliminar Hoja de Vida en la base de datos");	
					response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
					return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
				}
			  response.put("mensaje", "Hoja de Vida se ha eliminado con éxito!");		
			  return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

		 }
}
