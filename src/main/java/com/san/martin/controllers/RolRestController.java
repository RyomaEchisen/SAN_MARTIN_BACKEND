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

import com.san.martin.models.entity.Rol;
import com.san.martin.models.services.IRolService;

@RestController
@RequestMapping("/api_roles")
public class RolRestController {
	@Autowired
	private IRolService rolService;
	
	@GetMapping("/roles")
	public List<Rol> index(){
		return rolService.findAll();
}
//Crud
	//listar
	@GetMapping("/roles/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {
		
		Rol rol = null;
		Map<String, Object> response = new HashMap<>();
	
		try {
			rol = rolService.findById(id);
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
		
		
		if(rol == null) {
			response.put("mensaje", "Rol ID: ".concat(id.toString().concat(" --No existe en la base de Datos")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
			
		}
		return new ResponseEntity<Rol>(rol, HttpStatus.OK);
		
    }
	//crear
	//entity para las restricciones 
	@PostMapping("/roles")
	public ResponseEntity<?> create(@RequestBody Rol rol) {
		
		Rol rolNew = null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			rolNew = rolService.saveRol(rol);
		
		} catch(DataAccessException e) {
			
			response.put("mensaje", "Error al realizar el insert en la base de datos");	
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "Rol se creo con Éxito!!");
		response.put("rol", rolNew);
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);
		
	}
    //Editar, Actualizar
	@PutMapping("/roles/{id}")
	public ResponseEntity<?>  update(@RequestBody Rol rol, @PathVariable Long id ){
	     Rol rolActual= rolService.findById(id);
	     Rol rolUpdated = null;
	     
	     Map<String, Object> response = new HashMap<>();
	     if(rolActual == null) {
				response.put("mensaje", "Error: no se puede editar, Rol ID: ".concat(id.toString().concat(" --No existe en la base de Datos")));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
				}
	     
	     try {
	     rolActual.setNombre(rol.getNombre());
	     
	     
	     
	     rolUpdated = rolService.saveRol(rolActual);
	     } catch(DataAccessException e) {
			
			response.put("mensaje", "Error al Actualizar Rol en la base de datos");	
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	     
	     response.put("mensaje", "Rol ha sido actualizado con Éxito!!");
		 response.put("rol", rolUpdated);
	     return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);
	     
	     }
	
	 @DeleteMapping("/roles/{id}")
	     @ResponseStatus(HttpStatus.NO_CONTENT)
	     public ResponseEntity<?> delete(@PathVariable Long id) {
		 Map<String, Object> response = new HashMap<>();
		 
		 
		  try {
	     
	        rolService.deleterolById(id);
		  } catch(DataAccessException e) {
				
				response.put("mensaje", "Error al Eliminar Rol en la base de datos");	
				response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		  response.put("mensaje", "Rol se ha eliminado con éxito!");		
		  return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

	 	}

}
