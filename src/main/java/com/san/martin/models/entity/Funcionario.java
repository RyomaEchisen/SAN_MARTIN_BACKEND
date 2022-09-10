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
@Table(name="funcionarios")
public class Funcionario implements Serializable {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String cargo;
	private String tipoFuncionario;
	private int estado;
	private Date fechaInicio;
	private Date fechaFin;

	
	@ManyToOne(fetch=FetchType.LAZY)
	private Persona persona;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Sucursal sucursal;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="funcionario", cascade=CascadeType.ALL)
	private List<Usuario> usuarios;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="funcionario", cascade=CascadeType.ALL)
	private List<Formulario> formularios;
	
	public Funcionario() {
		this.usuarios = new ArrayList<>();
		this.formularios = new ArrayList<>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getTipoFuncionario() {
		return tipoFuncionario;
	}

	public void setTipoFuncionario(String tipoFuncionario) {
		this.tipoFuncionario = tipoFuncionario;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	
	
	/// usuarios

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
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
