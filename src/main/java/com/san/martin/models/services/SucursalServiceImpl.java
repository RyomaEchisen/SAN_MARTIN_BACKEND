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

}
