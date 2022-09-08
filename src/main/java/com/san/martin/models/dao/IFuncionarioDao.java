package com.san.martin.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.san.martin.models.entity.Funcionario;

public interface IFuncionarioDao extends CrudRepository<Funcionario, Long> {

}
