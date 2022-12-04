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

import com.san.martin.models.entity.Sucursal;
import com.san.martin.models.services.ISucursalService;

@RestController
@RequestMapping("/sucursales")
public class SucursalRestController {
	
	@Autowired
	private ISucursalService sucursalService;
	
	@GetMapping("")
	public List<Sucursal> index(){
		return sucursalService.findAll();
	}
	//Crud
	//listar
		@GetMapping("/{id}")
		public ResponseEntity<?> show(@PathVariable Long id) {
			
			Sucursal sucursal = null;
			Map<String, Object> response = new HashMap<>();
		
			try {
				sucursal = sucursalService.findById(id);
			} catch(DataAccessException e) {
				response.put("mensaje", "Error al realizar la consulta en la base de datos");
				response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			    
			}
			
			if(sucursal == null) {
				response.put("mensaje", "Sucursal ID: ".concat(id.toString().concat(" --No existe en la base de Datos")));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
				
			}
			return new ResponseEntity<Sucursal>(sucursal, HttpStatus.OK);
			
			
	
	    }
		//crear
		//entity para las restricciones 
		@PostMapping("")
		public ResponseEntity<?> create(@RequestBody Sucursal sucursal) {
			
			
			Sucursal sucursalNew = null;
			Map<String, Object> response = new HashMap<>();

			try {
				sucursalNew = sucursalService.saveSucursal(sucursal);
			
			} catch(DataAccessException e) {
				
				response.put("mensaje", "Error al realizar el insert en la base de datos");	
				response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			response.put("mensaje", "sucursal ha sido creado con Éxito!!");
			response.put("sucursal", sucursalNew);
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);
			
		}
	    //Editar
		@PutMapping("/{id}")
		public ResponseEntity<?>  update(@RequestBody Sucursal sucursal, @PathVariable Long id ){
		     Sucursal sucursalActual= sucursalService.findById(id);
		     
		     Sucursal sucursalUpdated = null;
		     
		     Map<String, Object> response = new HashMap<>();
		     if(sucursalActual == null) {
					response.put("mensaje", "Error: no se puede editar, Sucursal ID: ".concat(id.toString().concat(" --No existe en la base de Datos")));
					return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
					
					
				}
		     
		     try {
		     sucursalActual.setNombre(sucursal.getNombre());
		     
		     
		     sucursalUpdated = sucursalService.saveSucursal(sucursalActual);
		     } catch(DataAccessException e) {
				
				response.put("mensaje", "Error al Aactualizar Sucursal en la base de datos");	
				response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		     
		     response.put("mensaje", "Sucursal se Actualizó con Éxito!!");
			 response.put("sucursal", sucursalUpdated);
		     return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);
		     
		     }
		
		 @DeleteMapping("/{id}")
		     @ResponseStatus(HttpStatus.NO_CONTENT)
		     public ResponseEntity<?> delete(@PathVariable Long id) {
			 Map<String, Object> response = new HashMap<>();
			 
			 
			  try {
		     
				sucursalService.deletesucursalById(id);
			  } catch(DataAccessException e) {
					
					response.put("mensaje", "Error al Eliminar Sucursal en la base de datos");	
					response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
					return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
				}
			  response.put("mensaje", "Sucursal se Eliminó con éxito!");		
			  return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

		 	}

}
