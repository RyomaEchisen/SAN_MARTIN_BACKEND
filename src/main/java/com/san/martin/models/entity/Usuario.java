package com.san.martin.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="usuarios")
public class Usuario implements Serializable {
	
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String numeroDocumento;
	private String rol;
	private String password;
	private Date fechaFinDocumentacion;
	private int estado;

	
	@ManyToOne(fetch=FetchType.LAZY)
	private Funcionario funcionario;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="usuario", cascade=CascadeType.ALL)
	private List<Evento> eventos;
	
	public Usuario() {
		this.eventos = new ArrayList<>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getFechaFinDocumentacion() {
		return fechaFinDocumentacion;
	}

	public void setFechaFinDocumentacion(Date fechaFinDocumentacion) {
		this.fechaFinDocumentacion = fechaFinDocumentacion;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}
	
	
	///evento
	public List<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}
	
	
	
	private static final long serialVersionUID = 1L;

}
