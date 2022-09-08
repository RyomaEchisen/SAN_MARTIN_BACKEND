package com.san.martin.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.san.martin.models.entity.Usuario;

public interface IUsuarioDao extends CrudRepository<Usuario, Long>{

}
