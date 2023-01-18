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

import com.san.martin.models.entity.Formulario;
import com.san.martin.models.services.IFormularioService;

@RestController
@RequestMapping("/api_formulario")
public class FormularioRestController {
	
	@Autowired 
	private IFormularioService formularioService;
	
	@GetMapping("/formulariosuser/{id}")
	public List<Formulario> listuser(@PathVariable Long id) {
		return formularioService.findByUserId(id);
	}
	/// 
	@GetMapping("/formularios")
	public List<Formulario> index(){
		System.out.println("olga");
		System.out.println(formularioService.findAll());
		return formularioService.findAll();
	}
	//Crud
		//listar
		@GetMapping("/formularios/{id}")
		public ResponseEntity<?> show(@PathVariable Long id) {
			
			Formulario formulario = null;
			Map<String, Object> response = new HashMap<>();
		
			try {
				formulario = formularioService.findById(id);
			} catch(DataAccessException e) {
				response.put("mensaje", "Error al realizar la consulta en la base de datos");
				response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			    
			}
			
			
			if(formulario == null) {
				response.put("mensaje", "Formulario ID: ".concat(id.toString().concat(" --No existe en la base de Datos")));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
				
			}
			return new ResponseEntity<Formulario>(formulario, HttpStatus.OK);
			
			
			
		
	    }
		//crear
		//entity para las restricciones no hay
		@PostMapping("/formularios")
		public ResponseEntity<?> create(@RequestBody Formulario formulario) {
			
			
			Formulario formularioNew = null;
			Map<String, Object> response = new HashMap<>();
			System.out.println("formulario");
			System.out.println(formulario.getUsuario());
			try {
				//formularioNew.setUsuario(formulario.getUsuario());
			
				formularioNew = formularioService.saveFormulario(formulario);
				
			
			} catch(DataAccessException e) {
				
				response.put("mensaje", "Error al realizar el insert en la base de datos");	
				response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			response.put("mensaje", "El Formulario ha sido creado con Éxito!!");
			response.put("formulario", formularioNew);
			response.put("datos del formulario", formulario);
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);
			
		}
	    //Editar
		@PutMapping("/formulario/{id}")
		public ResponseEntity<?>  update(@RequestBody Formulario formulario, @PathVariable Long id ){
			Formulario formularioActual= formularioService.findById(id);
		     
			Formulario formularioUpdated = null;
		     
		     Map<String, Object> response = new HashMap<>();
		     if(formularioActual == null) {
					response.put("mensaje", "Error: no se puede editar, El Formulario ID: ".concat(id.toString().concat(" --No existe en la base de Datos")));
					return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
					
					}
		     
		     try {
		    	 
		    	 formularioActual.setTipoF(formulario.getTipoF());
		    	 formularioActual.setNombre(formulario.getNombre());
		    	 formularioActual.setCargo(formulario.getCargo());
		    	 formularioActual.setMotivo(formulario.getMotivo());
		    	 formularioActual.setTipoDeLicencia(formulario.getTipoDeLicencia());
		    	 formularioActual.setTiempo(formulario.getTiempo());
		    	 formularioActual.setFechaInicio(formulario.getFechaInicio());
		    	 formularioActual.setFechaFin(formulario.getFechaFin());
		    	 formularioActual.setDeHora(formulario.getDeHora());
		    	 formularioActual.setaHora(formulario.getaHora());
		    	 formularioActual.setFechaRetorno(formulario.getFechaRetorno());
		    	 formularioActual.setGestion(formulario.getGestion());
		    	 formularioActual.setFecha(formulario.getFecha());
		    	 formularioActual.setComprobanteId(formulario.getComprobanteId());
		    	 formularioActual.setPdfId(formulario.getPdfId());
		    	 formularioActual.setObservaciones(formulario.getObservaciones());
		    	 //formularioActual.setFechacreacion(formulario.getFechacreacion());
		    	 
		     
		     
		    	 formularioUpdated = formularioService.saveFormulario(formularioActual);
		     } catch(DataAccessException e) {
				
				response.put("mensaje", "Error al Actualizar Formulario en la base de datos");	
				response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		     
		     response.put("mensaje", "El Formulario ha sido actualizado con Éxito!!");
			 response.put("formulario", formularioUpdated);
		     return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);
		     
		     }
		
		 @DeleteMapping("/formularios/{id}")
		     @ResponseStatus(HttpStatus.NO_CONTENT)
		     public ResponseEntity<?> delete(@PathVariable Long id) {
			 Map<String, Object> response = new HashMap<>();
			 
			 
			  try {
		     
				formularioService.deleteformularioById(id);
			  } catch(DataAccessException e) {
					
					response.put("mensaje", "Error al Eliminar el Formulario en la base de datos");	
					response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
					return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
				}
			  response.put("mensaje", "El Formulario se ha eliminado con éxito!");		
			  return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

		 	}
}
