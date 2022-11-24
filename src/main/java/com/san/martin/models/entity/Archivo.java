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
@Table(name="archivos")
public class Archivo implements Serializable {


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private Long tamanio;
	private String formato;
	private String ruta;
	private String documento;// se inserta Documento 

	@OneToMany(fetch=FetchType.LAZY, mappedBy="archivo", cascade=CascadeType.ALL)
	private List<Cursos> cursos;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="archivo", cascade=CascadeType.ALL)
	private List<Distinciones> distinciones;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="archivo", cascade=CascadeType.ALL)
	private List<ExperienciaLaboral> experienciaLaborales;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="archivo", cascade=CascadeType.ALL)
	private List<FormacionAcademica> formacionAcademicas;
	
	public Archivo() {
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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getTamanio() {
		return tamanio;
	}

	public void setTamanio(Long tamanio) {
		this.tamanio = tamanio;
	}
	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getFormato() {
		return formato;
	}

	public void setFormato(String formato) {
		this.formato = formato;
	}

	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
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
	
	
	///formacionAcademica
	public List<FormacionAcademica> getFormacionAcademicas() {
		return formacionAcademicas;
	}

	public void setFormacionAcademicas(List<FormacionAcademica> formacionAcademicas) {
		this.formacionAcademicas = formacionAcademicas;
	}

	private static final long serialVersionUID = 1L;
}
