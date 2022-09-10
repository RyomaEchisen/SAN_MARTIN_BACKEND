package com.san.martin.models.services;

import java.util.List;

import com.san.martin.models.entity.Funcionario;


public interface IFuncionarioService {

	public List<Funcionario> findAll();
	public Funcionario findById(Long id);
	public Funcionario saveFuncionario(Funcionario funcionario);
	public void deletefuncionarioById(Long id);
}
