package com.san.martin.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="experiencia")
public class ExperienciaLaboral implements Serializable{


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String institucion;
	private String tipo;
	private String duracion;
	private String cargo;
	private Date fechaInicio;
	private Date fechaFin;
	private String motivoFinalizacion;

	
	@ManyToOne(fetch=FetchType.LAZY)
	private HojaDeVida hojaDeVida;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Archivo archivo;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getInstitucion() {
		return institucion;
	}

	public void setInstitucion(String institucion) {
		this.institucion = institucion;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDuracion() {
		return duracion;
	}

	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
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

	public String getMotivoFinalizacion() {
		return motivoFinalizacion;
	}

	public void setMotivoFinalizacion(String motivoFinalizacion) {
		this.motivoFinalizacion = motivoFinalizacion;
	}
	private static final long serialVersionUID = 1L;

}
