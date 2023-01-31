package com.san.martin.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import com.san.martin.models.entity.Vacaciones;



public interface IVacacionDao extends CrudRepository<Vacaciones, Long>{
	@Query("select w from Vacaciones w where usuario_id=?1")
	List<Vacaciones> findUserAll(Long id);

	@Query("select w from Vacaciones w where usuario_id=?1 and w.gestion=?2")
	Vacaciones findUserGestion(Long id, String gestion);
	

}
