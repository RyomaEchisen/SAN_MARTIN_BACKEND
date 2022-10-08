package com.san.martin.models.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.san.martin.models.dao.IRolDao;
import com.san.martin.models.entity.Rol;

@Service
public class RolServiceImpl implements IRolService{
	@Autowired
	private IRolDao rolDao;
	@Override
	//copiar el transactional lectura
	@Transactional(readOnly = true)
	public List<Rol> findAll(){ //es para accedes a la lista de rol
		return (List<Rol>) rolDao.findAll(); //retorna un iterable, por lo tanto tenemos un lis
	

	}
	@Override
	@Transactional (readOnly = true)
	public Rol findById(Long id) {
	//1.4
		return rolDao.findById(id).orElse(null);
	}
	@Override
	//1.2 transactional completo
	@Transactional
	public Rol saveRol(Rol rol) {
		// TODO Auto-generated method stub
		return rolDao.save(rol);
	}
	//1.3 transactionalcompleto
	@Override
	@Transactional
	public void deleterolById(Long id) {
		// TODO Auto-generated method stub
		//1.5
	rolDao.deleteById(id);
		

	}
}
