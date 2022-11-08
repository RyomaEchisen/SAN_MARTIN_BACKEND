package com.san.martin.controllers;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.san.martin.models.entity.Persona;
import com.san.martin.models.services.IPersonaService;

@RestController
@RequestMapping("/api")
public class PersonaRestController {
	
	@Autowired
	private IPersonaService personaService;
	
	@GetMapping("/personas")
	public List<Persona> index(){
		return personaService.findAll();
	}
	//Crud
	//listar
	@GetMapping("/personas/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {
		
		Persona persona = null;
		Map<String, Object> response = new HashMap<>();
	
		try {
			persona = personaService.findById(id);
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		    
		}
		
		
		if(persona == null) {
			response.put("mensaje", "La persona ID: ".concat(id.toString().concat(" --No existe en la base de Datos")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
			
		}
		return new ResponseEntity<Persona>(persona, HttpStatus.OK);
		
		
		
	
    }
	//crear
	//entity para las restricciones 
	@PostMapping("/personas")
	public ResponseEntity<?> create(@RequestBody Persona persona) {
		
		
		Persona personaNew = null;
		Map<String, Object> response = new HashMap<>();
		//3.39.
		try {
			personaNew = personaService.savePersona(persona);
		
		} catch(DataAccessException e) {
			
			response.put("mensaje", "Error al realizar el insert en la base de datos");	
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "La Persona ha sido creado con Éxito!!");
		response.put("persona", personaNew);
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);
		
	}
    //Editar
	@PutMapping("/personas/{id}")
	public ResponseEntity<?>  update(@RequestBody Persona persona, @PathVariable Long id ){
	     Persona personaActual= personaService.findById(id);
	     
	     Persona personaUpdated = null;
	     
	     Map<String, Object> response = new HashMap<>();
	     if(personaActual == null) {
				response.put("mensaje", "Error: no se puede editar, La persona ID: ".concat(id.toString().concat(" --No existe en la base de Datos")));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
				
				
			}
	     
	     try {
	     personaActual.setApellidoCasada(persona.getApellidoCasada());
	     personaActual.setArchivoDoc(persona.getArchivoDoc());
	     personaActual.setCel(persona.getCel());
	     personaActual.setCorreo(persona.getCorreo());
	     personaActual.setDireccion(persona.getDireccion());
	     personaActual.setEstadoCivil(persona.getEstadoCivil());
	     personaActual.setExiteRelacionParentesco(persona.isExiteRelacionParentesco());
	     personaActual.setExpedicion(persona.getExpedicion());
	     personaActual.setFax(persona.getFax());
	     personaActual.setFechaNacimiento(persona.getFechaNacimiento());
	     personaActual.setFechacreacion(persona.getFechacreacion());
	     personaActual.setFotoId(persona.getFotoId());
	     personaActual.setGradoParentesco(persona.getGradoParentesco());
	     personaActual.setMaterno(persona.getMaterno());
	     personaActual.setNacDepartamento(persona.getNacDepartamento());
	     personaActual.setNacDoc(persona.getNacDoc());
	     personaActual.setNacLocalidad(persona.getNacLocalidad());
	     personaActual.setNacPais(persona.getNacPais());
	     personaActual.setNacProvincia(persona.getNacProvincia());
	     personaActual.setNacionalidad(persona.getNacionalidad());
	     personaActual.setNombreCompletoPariente(persona.getNombreCompletoPariente());
	     personaActual.setNombres(persona.getNombres());
	     personaActual.setNumeroDeDependencia(persona.getNumeroDeDependencia());
	     personaActual.setNumeroDocumento(persona.getNumeroDocumento());
	     personaActual.setPaterno(persona.getPaterno());
	     personaActual.setProfesion(persona.getProfesion());
	     personaActual.setRelacionFamiliar(persona.getRelacionFamiliar());
	     personaActual.setResDepartamento(persona.getResDepartamento());
	     personaActual.setResLocalidad(persona.getResLocalidad());
	     personaActual.setResPais(persona.getResPais());
	     personaActual.setResProvincia(persona.getResProvincia());
	     personaActual.setSexo(persona.getSexo());
	     personaActual.setTelfDomi(persona.getTelfDomi());
	     personaActual.setTelfTrabajo(persona.getTelfTrabajo());
	     personaActual.setTipoDocumento(persona.getTipoDocumento());
	     
	     
	     personaUpdated = personaService.savePersona(personaActual);
	     } catch(DataAccessException e) {
			
			response.put("mensaje", "Error al Actualizar Persona en la base de datos");	
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	     
	     response.put("mensaje", "La Persona ha sido actualizada con Éxito!!");
		 response.put("persona", personaUpdated);
	     return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);
	     
	     }
	
	 @DeleteMapping("/personas/{id}")
	     @ResponseStatus(HttpStatus.NO_CONTENT)
	     public ResponseEntity<?> delete(@PathVariable Long id) {
		 Map<String, Object> response = new HashMap<>();
		 
		 
		  try {
			  Persona persona = personaService.findById(id);
			  String nombreFotoAnterior = persona.getFotoId();
				 if(nombreFotoAnterior !=null && nombreFotoAnterior.length() >0) {
					 Path rutaFotoAnterior = Paths.get("uploads").resolve(nombreFotoAnterior).toAbsolutePath();
					 File archivoFotoAnterior = rutaFotoAnterior.toFile();
					 if(archivoFotoAnterior.exists() && archivoFotoAnterior.canRead()) {
						 archivoFotoAnterior.delete();
					 }
				 }
			  
			  
			  
	        personaService.deletepersonaById(id);
		  } catch(DataAccessException e) {
				
				response.put("mensaje", "Error al Eliminar la Persona en la base de datos");	
				response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		  response.put("mensaje", "La Persona se ha eliminado con éxito!");		
		  return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

	 	}
	 @PostMapping("/personas/upload")
	 public ResponseEntity<?>upload(@RequestParam("archivo") MultipartFile archivo, @RequestParam("id") Long id){
		 Map<String, Object> response = new HashMap<>();
		 Persona persona = personaService.findById(id);
		 if(!archivo.isEmpty()) {
			 String nombreArchivo = UUID.randomUUID().toString() + "_" + archivo.getOriginalFilename();
			 Path rutaArchivo = Paths.get("uploads").resolve(nombreArchivo).toAbsolutePath();
			 try {
				 Files.copy(archivo.getInputStream(), rutaArchivo);
			 } catch (IOException e) {
				 response.put("mensaje", "Error al subir la imagen de la persona " + nombreArchivo);	
				 response.put("error", e.getMessage().concat(": ").concat(e.getCause().getMessage()));
				 return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			 }
			 String nombreFotoAnterior = persona.getFotoId();
			 if(nombreFotoAnterior !=null && nombreFotoAnterior.length() >0) {
				 Path rutaFotoAnterior = Paths.get("uploads").resolve(nombreFotoAnterior).toAbsolutePath();
				 File archivoFotoAnterior = rutaFotoAnterior.toFile();
				 if(archivoFotoAnterior.exists() && archivoFotoAnterior.canRead()) {
					 archivoFotoAnterior.delete();
				 }
			 }
			 persona.setFotoId(nombreArchivo);
			 personaService.savePersona(persona);
			 response.put("persona", persona);
			 response.put("mensaje","Has subido correctamente la imagen: " + nombreArchivo);
		 }
		 return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);
	 }
	 
	 @GetMapping("/uploads/img/{nombreFoto:.+}")
	 public ResponseEntity<Resource> verFoto(@PathVariable String nombreFoto) {
		 
		 Path rutaArchivo = Paths.get("uploads").resolve(nombreFoto).toAbsolutePath();
		 
		 Resource recurso = null;
		 
		 try {
			recurso = new UrlResource(rutaArchivo.toUri());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		 if(!recurso.exists() && !recurso.isReadable()) {
			 throw new RuntimeException("Error no se pudo cargar la imagen: " + nombreFoto);
		 }
		 HttpHeaders cabecera = new HttpHeaders();
		 cabecera.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + recurso.getFilename() + "\"");
		 
		 return new ResponseEntity<Resource>(recurso, cabecera,  HttpStatus.OK);
	 }
}






