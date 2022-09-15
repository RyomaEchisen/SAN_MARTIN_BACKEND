package com.san.martin.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.san.martin.models.dao.IUsuarioDao;
import com.san.martin.models.entity.Usuario;

@Service
public class UsuarioServiceImpl implements IUsuarioService{
    
	@Autowired
	private IUsuarioDao usuarioDao;
	
	@Override
	
	@Transactional(readOnly = true)
	public List<Usuario> findAll() {
		
		return (List<Usuario>) usuarioDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Usuario findById(Long id) {
		return usuarioDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Usuario saveUsuario(Usuario usuario) {
		return usuarioDao.save(usuario);
	}

	@Override
	@Transactional
	public void deleteusuarioById(Long id) {
		usuarioDao.deleteById(id);
	}
}
 





