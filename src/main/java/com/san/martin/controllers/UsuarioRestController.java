package com.san.martin.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.san.martin.models.dto.UsuarioLogin;
import com.san.martin.models.entity.Usuario;
import com.san.martin.models.services.IUsuarioService;

//@EnableGlobalMethodSecurity(securedEnabled=true)
@CrossOrigin(maxAge = 3600, origins = "http://localhost:4200")
@RestController
@RequestMapping("/api_usuario")
public class UsuarioRestController {

  @Autowired
  private BCryptPasswordEncoder passwordEncoder;

  @Autowired
  private IUsuarioService usuarioService;

  @GetMapping("/usuarios")
  public List<Usuario> index() {
    return usuarioService.findAll();
  }

  // Crud
  // listar
  @Secured({ "ROLE_ADMIN", "ROLE_USER" }) // para subida de foto
  @GetMapping("/usuarios/{id}")
  public ResponseEntity<?> show(@PathVariable Long id) {

    Usuario usuario = null;
    Map<String, Object> response = new HashMap<>();

    try {
      usuario = usuarioService.findById(id);
    } catch (DataAccessException e) {
      response.put("mensaje", "Error al realizar la consulta en la base de datos");
      response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
      return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    if (usuario == null) {
      response.put("mensaje", "Usuario ID: ".concat(id.toString().concat(" --No existe en la base de Datos")));
      return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);

    }
    return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
  }

  // crear
  // entity para las restricciones
  @Secured({ "ROLE_ADMIN" })
  @PostMapping("/usuarios")
  public ResponseEntity<?> create(@RequestBody Usuario usuario) {

    Usuario usuarioNew = null;
    Map<String, Object> response = new HashMap<>();
    try {
      usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
      usuarioNew = usuarioService.saveUsuario(usuario);

    } catch (DataAccessException e) {

      response.put("mensaje", "Error al realizar el insert en la base de datos");
      response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
      return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    response.put("mensaje", "El Usuario ha sido creado con Éxito!!");
    response.put("usuario", usuarioNew);
    return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);

  }

  // login
  // entity para iniciar sesion
  @PostMapping("/usuarios/login")
  public ResponseEntity<?> login(@RequestBody UsuarioLogin usuarioLogin) {
    Map<String, Object> response = new HashMap<>();
    System.out.println("Usuario logeado: \n" + usuarioLogin.getEmail());
    try {
      System.out.println("Usuario logeado: \n" + usuarioLogin.getEmail());
    } catch (DataAccessException e) {

      response.put("mensaje", "Error al realizar el insert en la base de datos");
      response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
      return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    response.put("mensaje", "El Usuario se a logueado con éxito!!");
    response.put("usuario", usuarioLogin);
    return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);

  }

  // Editar
  @Secured({ "ROLE_ADMIN" })
  @PutMapping("/usuarios/{id}")
  public ResponseEntity<?> update(@RequestBody Usuario usuario, @PathVariable Long id) {
    Usuario usuarioActual = usuarioService.findById(id);

    Usuario usuarioUpdated = null;

    Map<String, Object> response = new HashMap<>();
    if (usuarioActual == null) {
      response.put("mensaje", "Error: no se puede editar, El Usuario ID: "
          .concat(id.toString().concat(" --No existe en la base de Datos")));
      return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);

    }

    try {
      usuarioActual.setUsername(usuario.getUsername());
      usuarioActual.setPassword(usuario.getPassword());
      usuarioActual.setNombres(usuario.getNombres());
      usuarioActual.setEmail(usuario.getEmail());
      usuarioActual.setEnabled(usuario.getEnabled());
      usuarioActual.setApellidos(usuario.getApellidos());

      usuarioUpdated = usuarioService.saveUsuario(usuarioActual);
    } catch (DataAccessException e) {

      response.put("mensaje", "Error al Actualizar Usuario en la base de datos");
      response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
      return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    response.put("mensaje", "Usuario ha sido actualizado con Éxito!!");
    response.put("usuario", usuarioUpdated);
    return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);

  }

  @Secured({ "ROLE_ADMIN" })
  @DeleteMapping("/usuarios/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public ResponseEntity<?> delete(@PathVariable Long id) {
    Map<String, Object> response = new HashMap<>();

    try {

      usuarioService.deleteusuarioById(id);
    } catch (DataAccessException e) {

      response.put("mensaje", "Error al Eliminar Usuario en la base de datos");
      response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
      return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    response.put("mensaje", "Usuario Eliminado con éxito!");
    return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

  }
  // configuración en subida de Imagen y documentos
  // subida de imagen--- postmapping - persona/upload
  // @Secured({"ROLE_ADMIN","ROLE_USER"})
}
