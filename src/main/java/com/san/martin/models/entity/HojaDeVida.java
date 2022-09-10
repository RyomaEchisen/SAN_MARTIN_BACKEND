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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Persona persona;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy = "hojaDeVida", cascade=CascadeType.ALL)
	private List<Idioma> idiomas;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy = "hojaDeVida", cascade=CascadeType.ALL)
	private List<Conocimiento> conocimientos;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy = "hojaDeVida", cascade=CascadeType.ALL)
	private List<Referencia> referencias;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy = "hojaDeVida", cascade=CascadeType.ALL)
	private List<Cursos> cursos;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy = "hojaDeVida", cascade=CascadeType.ALL)
	private List<Distinciones> distinciones;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy = "hojaDeVida", cascade=CascadeType.ALL)
	private List<ExperienciaLaboral> experienciaLaborales;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy = "hojaDeVida", cascade=CascadeType.ALL)
	private List<FormacionAcademica> formacionAcademicas;
	
	public HojaDeVida() {
		this.idiomas=new ArrayList<>();
		this.conocimientos=new ArrayList<>();
		this.referencias=new ArrayList<>();
		this.cursos=new ArrayList<>();
		this.distinciones=new ArrayList<>();
		this.experienciaLaborales=new ArrayList<>();
		this.formacionAcademicas=new ArrayList<>();
	}
	
	

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
	
	
	
	///idiomas
	public List<Idioma> getIdiomas() {
		return idiomas;
	}



	public void setIdiomas(List<Idioma> idiomas) {
		this.idiomas = idiomas;
	}
	
	
	
	///conocimiento
	public List<Conocimiento> getConocimientos() {
		return conocimientos;
	}

	public void setConocimientos(List<Conocimiento> conocimientos) {
		this.conocimientos = conocimientos;
	}
	
	
	///referencia
	public List<Referencia> getReferencias() {
		return referencias;
	}

	public void setReferencias(List<Referencia> referencias) {
		this.referencias = referencias;
	}
	
	
	///cursos
	public List<Cursos> getCursos() {
		return cursos;
	}

	public void setCursos(List<Cursos> cursos) {
		this.cursos = cursos;
	}
	
	
	///distinciones
	public List<Distinciones> getDistinciones() {
		return distinciones;
	}

	public void setDistinciones(List<Distinciones> distinciones) {
		this.distinciones = distinciones;
	}
	
	
	///experienciaLaboral
	public List<ExperienciaLaboral> getExperienciaLaborales() {
		return experienciaLaborales;
	}

	public void setExperienciaLaborales(List<ExperienciaLaboral> experienciaLaborales) {
		this.experienciaLaborales = experienciaLaborales;
	}
	
	
	////formacionesAcademicas
	public List<FormacionAcademica> getFormacionAcademicas() {
		return formacionAcademicas;
	}

	public void setFormacionAcademicas(List<FormacionAcademica> formacionAcademicas) {
		this.formacionAcademicas = formacionAcademicas;
	}
	
	
	
	private static final long serialVersionUID = 1L;
}
