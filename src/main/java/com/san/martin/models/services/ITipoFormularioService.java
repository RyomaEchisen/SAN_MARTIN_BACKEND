package com.san.martin.models.services;

import java.util.List;

import com.san.martin.models.entity.TipoFormulario;

public interface ITipoFormularioService {
	
	public List<TipoFormulario> findAll();
	public TipoFormulario findById(Long id);
	public TipoFormulario saveTipoFormulario(TipoFormulario tipoFormulario);
	public void deletetipoFormularioById(Long id);
}
