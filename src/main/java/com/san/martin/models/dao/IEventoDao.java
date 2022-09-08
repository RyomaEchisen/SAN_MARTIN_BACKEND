package com.san.martin.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.san.martin.models.entity.Evento;

public interface IEventoDao extends CrudRepository<Evento, Long>{

}
