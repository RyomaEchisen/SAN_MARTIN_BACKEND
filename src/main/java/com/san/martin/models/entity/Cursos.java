package com.san.martin.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cursos")
public class Cursos implements Serializable{


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String institucion;
	private String nombreCurso;
	private int horasAcademincas;
	private String nota;
	private Date fecha;

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

	public String getNombreCurso() {
		return nombreCurso;
	}

	public void setNombreCurso(String nombreCurso) {
		this.nombreCurso = nombreCurso;
	}

	public int getHorasAcademincas() {
		return horasAcademincas;
	}

	public void setHorasAcademincas(int horasAcademincas) {
		this.horasAcademincas = horasAcademincas;
	}

	public String getNota() {
		return nota;
	}

	public void setNota(String nota) {
		this.nota = nota;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	private static final long serialVersionUID = 1L;
}
