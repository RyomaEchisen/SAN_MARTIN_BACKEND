package com.san.martin.models.services;

import java.util.List;

import com.san.martin.models.entity.Sucursal;

public interface ISucursalService {
	
	public List<Sucursal> findAll();
	public Sucursal findById(Long id);
	public Sucursal saveSucursal(Sucursal sucursal);
	public void deletesucursalById(Long id);

}
