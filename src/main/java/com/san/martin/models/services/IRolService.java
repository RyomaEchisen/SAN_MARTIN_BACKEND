package com.san.martin.models.services;

import java.util.List;

import com.san.martin.models.entity.Rol;

public interface IRolService {
	public List<Rol> findAll();
	public Rol findById(Long id);
	public Rol saveRol(Rol rol);
	public void deleterolById(Long id);

}
