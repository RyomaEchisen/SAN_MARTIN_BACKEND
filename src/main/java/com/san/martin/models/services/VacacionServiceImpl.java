package com.san.martin.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.san.martin.models.dao.IVacacionDao;
import com.san.martin.models.entity.Vacaciones;

@Service
public class VacacionServiceImpl implements IVacacionService{
	
	@Autowired
	private IVacacionDao vacacionDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Vacaciones> findAll(){
		
		return(List<Vacaciones>) vacacionDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Vacaciones findById(Long id) {
		return vacacionDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Vacaciones save(Vacaciones evento) {
		return vacacionDao.save(evento);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		vacacionDao.deleteById(id);
	}

	@Override
	public List<Vacaciones> findByUserId(Long id) {
		// TODO Auto-generated method stub
		return (List<Vacaciones>)vacacionDao.findUserAll(id);
		
	}

	@Override
	public Vacaciones findByUserIdGestion(Long id, String gestion) {
		// TODO Auto-generated method stub
		return (Vacaciones)vacacionDao.findUserGestion(id, gestion);
	}

}
