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

import com.san.martin.models.entity.Distinciones;
import com.san.martin.models.services.IDistincionesService;

@RestController
@RequestMapping("/api_distincion")
public class DistincionesRestController {

	@Autowired
	private IDistincionesService distincionesService;

	@GetMapping("/distinciones")
	public List<Distinciones> index() {
		return distincionesService.findAll();
	}

	// mostrar por id
	@GetMapping("/distinciones/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {

		Distinciones distinciones = null;

		Map<String, Object> response = new HashMap<>();

		try {
			distinciones = distincionesService.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if (distinciones == null) {
			response.put("mensaje",
					"El catalogo id: ".concat(id.toString().concat(" --no existe ne la base de datos ")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Distinciones>(distinciones, HttpStatus.OK);
	}

	// crear
	@PostMapping("/distinciones")
	public ResponseEntity<?> create(@RequestBody Distinciones distinciones) {

		Distinciones distincionesNew = null;
		Map<String, Object> response = new HashMap<>();

		try {
			distincionesNew = distincionesService.save(distinciones);
		} catch (DataAccessException e) {

			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);

		}
		response.put("mensaje:", "Catalogo creado correctamente");
		response.put("catalogo", distincionesNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);

	}

	// actualizar
	@PutMapping("/distinciones/{id}")
	public ResponseEntity<?> update(@RequestBody Distinciones distinciones, @PathVariable Long id) {

		Distinciones distincionesActual = distincionesService.findById(id);

		Distinciones distincionesUpdated = null;

		Map<String, Object> response = new HashMap<>();
		if (distincionesActual == null) {
			response.put("mensaje", "Error: no se puede editar el archivo Id: "
					.concat(id.toString().concat("no existe en la base de datos! ")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		try {
			distincionesActual.setInstitucion(distinciones.getInstitucion());
			distincionesActual.setNombre(distinciones.getNombre());
			distincionesActual.setFecha(distinciones.getFecha());

			distincionesUpdated = distincionesService.save(distincionesActual);

		} catch (DataAccessException e) {

			response.put("mensaje", "Error al actualizar en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);

		}
		response.put("mensaje", "La distincion ha sido actualizado con exito");
		response.put("distinciones", distincionesUpdated);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	// delete
	@DeleteMapping("/distinciones/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {

		Map<String, Object> response = new HashMap<>();
		try {
			distincionesService.delete(id);
		} catch (DataAccessException e) {

			response.put("mensaje", "Error al eliminar distinciones en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "Distinciones eliminado con exito");

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
}
