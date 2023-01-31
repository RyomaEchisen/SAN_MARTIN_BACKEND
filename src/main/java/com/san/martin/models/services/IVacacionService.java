package com.san.martin.models.services;

import java.util.List;


import com.san.martin.models.entity.Vacaciones;

public interface IVacacionService {
	
	public List<Vacaciones> findAll();
	
	public Vacaciones findById(Long id);
	
	public Vacaciones save (Vacaciones evento);
	
	public void delete(Long id);

	public List<Vacaciones> findByUserId(Long id);

	public Vacaciones findByUserIdGestion(Long id, String gestion);

}
