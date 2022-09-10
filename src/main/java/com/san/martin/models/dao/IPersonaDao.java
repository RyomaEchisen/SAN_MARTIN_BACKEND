package com.san.martin.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.san.martin.models.entity.Persona;

public interface IPersonaDao extends CrudRepository<Persona, Long>{

}
