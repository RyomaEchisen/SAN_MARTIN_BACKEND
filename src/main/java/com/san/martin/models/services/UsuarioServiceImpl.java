package com.san.martin.models.services;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.san.martin.models.dao.IUsuarioDao;
import com.san.martin.models.entity.Usuario;

@Service
public class UsuarioServiceImpl implements IUsuarioService,UserDetailsService {
	private Logger logger = LoggerFactory.getLogger(UsuarioServiceImpl.class);
	@Autowired
	private IUsuarioDao usuarioDao;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario =usuarioDao.findByUsername(username);
		if(usuario==null)
		{
			logger.error("error en el login: no existe el usuario'"+username+"' en el sistema!");
			throw new UsernameNotFoundException("error en el login: no existe el usuario'"+username+"' en el sistema!");
		}
		List<GrantedAuthority> authorities =usuario.getRoles()
				.stream()
				.map(role->new SimpleGrantedAuthority(role.getNombre()))
				.peek(authority->logger.info("Role: "+authority.getAuthority()))
				.collect(Collectors.toList());
		
		return  new User(usuario.getUsername(), usuario.getPassword(), usuario.getEnabled(), true, true, true,authorities );
	}
	
	
	//listar
	@Override
	
	@Transactional(readOnly = true)
	public List<Usuario> findAll() {
		
		return (List<Usuario>) usuarioDao.findAll();
	}
    //leer
	@Override
	@Transactional(readOnly = true)
	public Usuario findById(Long id) {
		return usuarioDao.findById(id).orElse(null);
	}
    //guardar
	@Override
	@Transactional
	public Usuario saveUsuario(Usuario usuario) {
		return usuarioDao.save(usuario);
	}
    //Eliminar
	@Override
	@Transactional
	public void deleteusuarioById(Long id) {
		usuarioDao.deleteById(id);
	}


	@Override
	public Usuario findByUsername(String username) {
		
		return usuarioDao.findByUsername(username);
	}

}
 





