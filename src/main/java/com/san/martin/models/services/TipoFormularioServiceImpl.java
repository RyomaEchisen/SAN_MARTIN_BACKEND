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

	@Override
	@Transactional(readOnly = true)
	public TipoFormulario findById(Long id) {
		// TODO Auto-generated method stub
		return tipoFormularioDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public TipoFormulario saveTipoFormulario(TipoFormulario tipoFormulario) {
		// TODO Auto-generated method stub
		return tipoFormularioDao.save(tipoFormulario);
	}

	@Override
	@Transactional
	public void deletetipoFormularioById(Long id) {
		// TODO Auto-generated method stub
		tipoFormularioDao.deleteById(id);
	}
}
