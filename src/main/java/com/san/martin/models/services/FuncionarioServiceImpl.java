package com.san.martin.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.san.martin.models.dao.IFuncionarioDao;
import com.san.martin.models.entity.Funcionario;


@Service
public class FuncionarioServiceImpl implements IFuncionarioService{
	
	@Autowired
	private IFuncionarioDao funcionarioDao;
	
	@Override
	
	@Transactional(readOnly = true)
	public List<Funcionario> findAll(){
		
		return (List<Funcionario>) funcionarioDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Funcionario findById(Long id) {
		// TODO Auto-generated method stub
		return funcionarioDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Funcionario saveFuncionario(Funcionario funcionario) {
		// TODO Auto-generated method stub
		return funcionarioDao.save(funcionario);
	}

	@Override
	@Transactional
	public void deletefuncionarioById(Long id) {
		// TODO Auto-generated method stub
		funcionarioDao.deleteById(id);
		
	}

}
