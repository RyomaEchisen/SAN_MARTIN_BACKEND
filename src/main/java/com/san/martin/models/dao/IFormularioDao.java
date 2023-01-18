package com.san.martin.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.san.martin.models.entity.Formulario;

public interface IFormularioDao extends CrudRepository<Formulario, Long>{
	@Query("select f from Formulario f where usuario_id=?1")
    List<Formulario> findUserAll(Long id);

}
