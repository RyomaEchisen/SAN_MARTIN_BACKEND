package com.san.martin.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="hojaDeVidas")
public class HojaDeVida implements Serializable {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String lugarDeResidencia;
	private String perfilProfecional;
	private String colegioProfecional;
	private String numRegistroColegio;
	private String informacion;
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLugarDeResidencia() {
		return lugarDeResidencia;
	}

	public void setLugarDeResidencia(String lugarDeResidencia) {
		this.lugarDeResidencia = lugarDeResidencia;
	}

	public String getPerfilProfecional() {
		return perfilProfecional;
	}

	public void setPerfilProfecional(String perfilProfecional) {
		this.perfilProfecional = perfilProfecional;
	}

	public String getColegioProfecional() {
		return colegioProfecional;
	}

	public void setColegioProfecional(String colegioProfecional) {
		this.colegioProfecional = colegioProfecional;
	}

	public String getNumRegistroColegio() {
		return numRegistroColegio;
	}

	public void setNumRegistroColegio(String numRegistroColegio) {
		this.numRegistroColegio = numRegistroColegio;
	}

	public String getInformacion() {
		return informacion;
	}

	public void setInformacion(String informacion) {
		this.informacion = informacion;
	}
	
	
	
	private static final long serialVersionUID = 1L;
}
