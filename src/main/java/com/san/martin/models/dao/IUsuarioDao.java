package com.san.martin.models.dao;



import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.san.martin.models.entity.Usuario;

public interface IUsuarioDao extends CrudRepository<Usuario, Long>{
	/* para tener una consulta customizada query en spring jpa se tiene mas ejemplos*/
	public Usuario findByUsername(String username);
	//public Usuario finsByUsernameAndPassword(String username, String password);
	@Query("select u from Usuario u where u.username=?1")
	public Usuario findByUsername2(String username);
	
	@Query("select u from Usuario u where u.username=?1 or email=?1 and u.password=?2") 
	public Usuario userlog(String email, String pass);

}
