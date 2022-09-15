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

import com.san.martin.models.entity.TipoFormulario;
import com.san.martin.models.services.ITipoFormularioService;

@RestController
@RequestMapping("/api_tipoFormulario")
public class TipoFormularioRestController {

	@Autowired
	private ITipoFormularioService tipoFormularioService;
	
	@GetMapping("/tipoFormularios")
	public List<TipoFormulario> index(){
		return tipoFormularioService.findAll();
	}
	//Crud
		//listar
		@GetMapping("/tipoFormularios/{id}")
		public ResponseEntity<?> show(@PathVariable Long id) {
			
			TipoFormulario tipoFormulario = null;
			Map<String, Object> response = new HashMap<>();
		
			try {
				tipoFormulario = tipoFormularioService.findById(id);
			} catch(DataAccessException e) {
				response.put("mensaje", "Error al realizar la consulta en la base de datos");
				response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			    
			}
			
			
			if(tipoFormulario == null) {
				response.put("mensaje", "tipoFormulario ID: ".concat(id.toString().concat(" --No existe en la base de Datos")));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
				
			}
			return new ResponseEntity<TipoFormulario>(tipoFormulario, HttpStatus.OK);
			
			
	    }
		//crear
		//entity para las restricciones 
		@PostMapping("/tipoFormularios")
		public ResponseEntity<?> create(@RequestBody TipoFormulario tipoFormulario) {
			
			
			TipoFormulario tipoFormularioNew = null;
			Map<String, Object> response = new HashMap<>();
			
			try {
				tipoFormularioNew = tipoFormularioService.saveTipoFormulario(tipoFormulario);
			
			} catch(DataAccessException e) {
				
				response.put("mensaje", "Error al realizar el insert en la base de datos");	
				response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			response.put("mensaje", "Tipo Formulario creado con Éxito!!");
			response.put("tipoFormulario", tipoFormularioNew);
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);
			
		}
	    //Editar
		@PutMapping("/tipoFormularios/{id}")
		public ResponseEntity<?>  update(@RequestBody TipoFormulario tipoFormulario, @PathVariable Long id ){
			 TipoFormulario tipoFormularioActual= tipoFormularioService.findById(id);
		     
			 TipoFormulario tipoFormularioUpdated = null;
		     
		     Map<String, Object> response = new HashMap<>();
		     if(tipoFormularioActual == null) {
					response.put("mensaje", "Error: no se puede editar, Tipo Formulario ID: ".concat(id.toString().concat(" --No existe en la base de Datos")));
					return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
					
					
				}
		     
		     try {
		    	 tipoFormularioActual.setNombre(tipoFormulario.getNombre());
		    	 tipoFormularioActual.setConHoras(tipoFormulario.isConHoras());
		    	 tipoFormularioActual.setConFechaRetorno(tipoFormulario.isConFechaRetorno());
		    

		      
		       tipoFormularioUpdated = tipoFormularioService.saveTipoFormulario(tipoFormularioActual);
		     } catch(DataAccessException e) {
				
				response.put("mensaje", "Error al Actualizar TipoFormulario en la base de datos");	
				response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		     
		     response.put("mensaje", "Tipo Formulario se Actualizó con Éxito!!");
			 response.put("tipoFormulario", tipoFormularioUpdated);
		     return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);
		     
		     }
		
		 @DeleteMapping("/tipoFormularios/{id}")
		     @ResponseStatus(HttpStatus.NO_CONTENT)
		     public ResponseEntity<?> delete(@PathVariable Long id) {
			 Map<String, Object> response = new HashMap<>();
			 
			  try {
		     
				  tipoFormularioService.deletetipoFormularioById(id);
			  } catch(DataAccessException e) {
					
					response.put("mensaje", "Error al Eliminar Tipo Formulario en la base de datos");	
					response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
					return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
				}
			  response.put("mensaje", "Tipo Formulario se ha eliminado con éxito!");		
			  return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

		 	}
	
	
	
	
	
}
