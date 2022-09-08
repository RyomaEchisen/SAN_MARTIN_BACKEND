package com.san.martin.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.san.martin.models.dao.ITipoFormularioDao;
import com.san.martin.models.entity.TipoFormulario;

@Service
public class TipoFormularioServiceImpl implements ITipoFormularioService{
	
	@Autowired
	private ITipoFormularioDao tipoFormularioDao;
	
	@Override
	
	@Transactional(readOnly = true)
	public List<TipoFormulario> findAll(){
		return (List<TipoFormulario>) tipoFormularioDao.findAll();
}
}
