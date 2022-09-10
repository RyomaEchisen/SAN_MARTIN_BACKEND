package com.san.martin.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tipoFormularios")
public class TipoFormulario implements Serializable  {


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private boolean conHoras;
	private boolean conFechaRetorno;
	
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="tipoFormulario", cascade=CascadeType.ALL)
	private List<Formulario> formularios;
	

	public TipoFormulario() {
		this.formularios = new ArrayList<>();
	}

	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean isConHoras() {
		return conHoras;
	}

	public void setConHoras(boolean conHoras) {
		this.conHoras = conHoras;
	}

	public boolean isConFechaRetorno() {
		return conFechaRetorno;
	}

	public void setConFechaRetorno(boolean conFechaRetorno) {
		this.conFechaRetorno = conFechaRetorno;
	}
	
	
	
	
	///formulario
	public List<Formulario> getFormularios() {
		return formularios;
	}



	public void setFormularios(List<Formulario> formularios) {
		this.formularios = formularios;
	}
	
	private static final long serialVersionUID = 1L;
}
