package com.san.martin.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.san.martin.models.dao.ISucursalDao;
import com.san.martin.models.entity.Sucursal;

@Service
public class SucursalServiceImpl implements ISucursalService{
	
	 
		@Autowired
		private ISucursalDao sucursalDao;
		
		@Override
		
		@Transactional(readOnly = true)
		public List<Sucursal> findAll(){
			
			return (List<Sucursal>) sucursalDao.findAll();
		}

		@Override
		@Transactional(readOnly = true)
		public Sucursal findById(Long id) {
			// TODO Auto-generated method stub
			return sucursalDao.findById(id).orElse(null);
		}

		@Override
		@Transactional
		public Sucursal saveSucursal(Sucursal sucursal) {
			// TODO Auto-generated method stub
			return sucursalDao.save(sucursal);
		}

		@Override
		@Transactional
		public void deletesucursalById(Long id) {
			// TODO Auto-generated method stub
			sucursalDao.deleteById(id);
			
		}
		

}
