package com.san.martin.models.services;

import java.util.List;

import com.san.martin.models.entity.HojaDeVida;


public interface IHojaDeVidaService {

	public List<HojaDeVida> findAll();
	public HojaDeVida findById(Long id);
	public HojaDeVida saveHojaDeVida(HojaDeVida hojaDeVida);
	public void deletehojaDeVidaById(Long id);
}
