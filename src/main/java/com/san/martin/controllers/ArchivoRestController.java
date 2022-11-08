package com.san.martin.controllers;

<<<<<<< HEAD

=======
>>>>>>> ab9db8d96184f22a63a4ca8aceaba3ade580157b
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.san.martin.models.entity.Archivo;
import com.san.martin.models.services.IArchivoService;

@RestController
@RequestMapping("/api_archivo")
public class ArchivoRestController {
<<<<<<< HEAD
	
	@Autowired
	private IArchivoService archivoService;
	//listar
	@GetMapping("/archivos")
	public List<Archivo> index(){
		return archivoService.findAll();
	}
	//mostrar por id
	@GetMapping("/archivos/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {
		
		Archivo archivo = null;
		
		Map<String, Object> response = new HashMap<>();
		
		try {
			archivo = archivoService.findById(id);
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
				
		if(archivo == null) {
			response.put("mensaje", "El archivo id: ".concat(id.toString().concat(" --no existe ne la base de datos ")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Archivo>(archivo, HttpStatus.OK);
	}
	//crear
	@PostMapping("/archivos")
	public ResponseEntity<?> create(@RequestBody Archivo archivo) {
		
		Archivo archivoNew = null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			 archivoNew = archivoService.save(archivo);
		}catch(DataAccessException e) {
			
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		response.put("mensaje:", "Archivo creado correctamente");
		response.put("archivo", archivoNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	
	}
	//actualizar
	@PutMapping("/archivos/{id}")  
	public ResponseEntity<?> update(@RequestBody Archivo archivo, @PathVariable Long id) {
		
		Archivo archivoActual = archivoService.findById(id);
		
		Archivo archivoUpdated = null;
		
		Map<String, Object> response = new HashMap<>();
		if(archivoActual == null) {
			response.put("mensaje", "Error: no se puede editar el archivo Id: ".concat(id.toString().concat("no existe en la base de datos! ")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		try {
			archivoActual.setFormato(archivo.getFormato());
			archivoActual.setNombre(archivo.getNombre());
			archivoActual.setRuta(archivo.getRuta());
			archivoActual.setTamanio(archivo.getTamanio());
			
			archivoUpdated = archivoService.save(archivoActual);
		
		}catch(DataAccessException e) {
			
			response.put("mensaje", "Error al actualizar en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		response.put("mensaje", "El archivo ha sido actualizado con exito");
		response.put("archivo", archivoUpdated);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	//delete 
	@DeleteMapping("/archivos/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		
		Map<String, Object> response = new HashMap<>();
		try {
			archivoService.delete(id);
		}catch(DataAccessException e) {
			
			response.put("mensaje", "Error al eliminar archivo en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "Archivo eliminado con exito");
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	@PostMapping("/archivos/upload")
	public ResponseEntity<?> upload(@RequestParam("doc")MultipartFile archivoD, @RequestParam("id") Long id ){
		
		Map<String, Object> response = new HashMap<>();
		
		Archivo archivo_doc = archivoService.findById(id);
			if(!archivoD.isEmpty()) {
				String nombreArchivo = archivoD.getOriginalFilename();   
				Path rutaArchivo = Paths.get("uploadsA").resolve(nombreArchivo).toAbsolutePath();
				
				try {
					Files.copy(archivoD.getInputStream(), rutaArchivo);
				} catch (IOException e) {
					response.put("mensaje", "Error al subir el archivo" + nombreArchivo);
					response.put("error", e.getMessage().concat(": ").concat(e.getCause().getMessage()));
					return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
				}
				archivo_doc.setDocumento(nombreArchivo);
				archivoService.save(archivo_doc);
				response.put("archivo", archivo_doc);
				response.put("mensaje", "Has subido correctamente la imagen: " + nombreArchivo);
			}
			
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
=======

  @Autowired
  private IArchivoService archivoService;

  // listar
  @GetMapping("/archivos")
  public List<Archivo> index() {
    return archivoService.findAll();
  }

  // mostrar por id
  @GetMapping("/archivos/{id}")
  public ResponseEntity<?> show(@PathVariable Long id) {

    Archivo archivo = null;

    Map<String, Object> response = new HashMap<>();

    try {
      archivo = archivoService.findById(id);
    } catch (DataAccessException e) {
      response.put("mensaje", "Error al realizar la consulta en la base de datos");
      response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
      return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    if (archivo == null) {
      response.put("mensaje", "El archivo id: ".concat(id.toString().concat(" --no existe ne la base de datos ")));
      return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<Archivo>(archivo, HttpStatus.OK);
  }

  // crear
  @PostMapping("/archivos")
  public ResponseEntity<?> create(@RequestBody Archivo archivo) {

    Archivo archivoNew = null;
    Map<String, Object> response = new HashMap<>();

    try {
      archivoNew = archivoService.save(archivo);
    } catch (DataAccessException e) {

      response.put("mensaje", "Error al realizar el insert en la base de datos");
      response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
      return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);

    }
    response.put("mensaje:", "Archivo creado correctamente");
    response.put("archivo", archivoNew);
    return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);

  }

  // actualizar
  @PutMapping("/archivos/{id}")
  public ResponseEntity<?> update(@RequestBody Archivo archivo, @PathVariable Long id) {

    Archivo archivoActual = archivoService.findById(id);

    Archivo archivoUpdated = null;

    Map<String, Object> response = new HashMap<>();
    if (archivoActual == null) {
      response.put("mensaje",
          "Error: no se puede editar el archivo Id: ".concat(id.toString().concat("no existe en la base de datos! ")));
      return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
    }
    try {
      archivoActual.setFormato(archivo.getFormato());
      archivoActual.setNombre(archivo.getNombre());
      archivoActual.setRuta(archivo.getRuta());
      archivoActual.setTamanio(archivo.getTamanio());

      archivoUpdated = archivoService.save(archivoActual);

    } catch (DataAccessException e) {

      response.put("mensaje", "Error al actualizar en la base de datos");
      response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
      return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);

    }
    response.put("mensaje", "El archivo ha sido actualizado con exito");
    response.put("archivo", archivoUpdated);
    return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
  }

  // delete
  @DeleteMapping("/archivos/{id}")
  public ResponseEntity<?> delete(@PathVariable Long id) {

    Map<String, Object> response = new HashMap<>();
    try {
      archivoService.delete(id);
    } catch (DataAccessException e) {

      response.put("mensaje", "Error al eliminar archivo en la base de datos");
      response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
      return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    response.put("mensaje", "Archivo eliminado con exito");

    return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
  }

  @PostMapping("/archivos/upload")
  public ResponseEntity<?> upload(@RequestParam("doc") MultipartFile archivoD, @RequestParam("id") Long id) {

    Map<String, Object> response = new HashMap<>();

    Archivo archivo_doc = archivoService.findById(id);
    if (!archivoD.isEmpty()) {
      String nombreArchivo = UUID.randomUUID().toString() + "_" + archivoD.getOriginalFilename().replace("", " ");
      // String nombreArchivo = archivoD.getOriginalFilename();
      Path rutaArchivo = Paths.get("uploadsA").resolve(nombreArchivo).toAbsolutePath();

      try {
        Files.copy(archivoD.getInputStream(), rutaArchivo);
      } catch (IOException e) {
        response.put("mensaje", "Error al subir el archivo" + nombreArchivo);
        response.put("error", e.getMessage().concat(": ").concat(e.getCause().getMessage()));
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
      }
      archivo_doc.setDocumento(nombreArchivo);
      archivoService.save(archivo_doc);
      response.put("archivo", archivo_doc);
      response.put("mensaje", "Has subido correctamente el Documento: " + nombreArchivo);
    }

    return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
  }

>>>>>>> ab9db8d96184f22a63a4ca8aceaba3ade580157b
}




















