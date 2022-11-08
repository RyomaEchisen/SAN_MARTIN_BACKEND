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

import com.san.martin.models.entity.Funcionario;
import com.san.martin.models.services.IFuncionarioService;

@RestController
@RequestMapping("/api_funcionario")
public class FuncionarioRestController {
	
	@Autowired
	private IFuncionarioService funcionarioService;
	
	@GetMapping("/funcionarios")
	public List<Funcionario> index(){
		return funcionarioService.findAll();
	}
    //Crud
	//listar
		@GetMapping("/funcionarios/{id}")
		public ResponseEntity<?> show(@PathVariable Long id) {
			
			Funcionario funcionario = null;
			Map<String, Object> response = new HashMap<>();
		
			try {
				funcionario = funcionarioService.findById(id);
			} catch(DataAccessException e) {
				response.put("mensaje", "Error al realizar la consulta en la base de datos");
				response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			    }
			
			
			if(funcionario == null) {
				response.put("mensaje", "Funcionario ID: ".concat(id.toString().concat(" --No existe en la base de Datos")));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
				
			}
			return new ResponseEntity<Funcionario>(funcionario, HttpStatus.OK);
			
			
	    }
		//crear funcionario
		//entity para las restricciones 
		@PostMapping("/funcionarios")
		public ResponseEntity<?> create(@RequestBody Funcionario funcionario) {
			
			Funcionario funcionarioNew = null;
			Map<String, Object> response = new HashMap<>();
			try {
				funcionarioNew = funcionarioService.saveFuncionario(funcionario);
			
			} catch(DataAccessException e) {
				
				response.put("mensaje", "Error al realizar el insert en la base de datos");	
				response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
	 			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			response.put("mensaje", "El Funcionario ha sido creado con Éxito!!");
			response.put("funcionario", funcionarioNew);
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);
			
		}
	    //Editar
		@PutMapping("/funcionarios/{id}")
		public ResponseEntity<?>  update(@RequestBody Funcionario funcionario, @PathVariable Long id ){
			Funcionario funcionarioActual= funcionarioService.findById(id);
		     
			Funcionario funcionarioUpdated = null;
		     
		     Map<String, Object> response = new HashMap<>();
		     if(funcionarioActual == null) {
					response.put("mensaje", "Error: no se puede editar, La persona ID: ".concat(id.toString().concat(" --No existe en la base de Datos")));
					return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
					
					
				}
		     
		     try {
		     funcionarioActual.setCargo(funcionario.getCargo());
		     funcionarioActual.setTipoFuncionario(funcionario.getTipoFuncionario());
		     funcionarioActual.setEstado(funcionario.getEstado());
		     funcionarioActual.setFechaInicio(funcionario.getFechaInicio());
		     funcionarioActual.setFechaFin(funcionario.getFechaFin());
		     
		     
		    funcionarioUpdated = funcionarioService.saveFuncionario(funcionarioActual);
		    } catch(DataAccessException e) {
				
				response.put("mensaje", "Error al Actualizar Funcionario en la base de datos");	
				response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		     
		     response.put("mensaje", "Funcionario ha sido actualizado con Éxito!!");
			 response.put("funcionario", funcionarioUpdated);
		     return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);
		     
		     }
		
		 @DeleteMapping("/funcionarios/{id}")
		     @ResponseStatus(HttpStatus.NO_CONTENT)
		     public ResponseEntity<?> delete(@PathVariable Long id) {
			 Map<String, Object> response = new HashMap<>();
			 
			 
			  try {
		     
		        funcionarioService.deletefuncionarioById(id);
			  } catch(DataAccessException e) {
					
					response.put("mensaje", "Error al Eliminar Funcionario en la base de datos");	
					response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
					return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
				}
			  response.put("mensaje", "El Funcionario se ha eliminado con éxito!");		
			  return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

		 	}

}
