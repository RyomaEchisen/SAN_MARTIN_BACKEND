package com.san.martin.models.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="formularios")
public class Formulario implements Serializable{
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String tipoF;
	private String nombre;
	private String cargo;
	private String motivo;
	private String tipoDeLicencia;
	private Long tiempo;
	private Date fechaInicio;
	private Date fechaFin;
	private String deHora;
	private String aHora;
	private Date fechaRetorno;
	private int gestion;
	private Date fecha;
	private Long comprobanteId;
	private Long pdfId;
	private String observaciones;
	@Column(name="create_fechacreacion")
	@Temporal(TemporalType.DATE)
	private Date fechacreacion;
	
	@PrePersist
	public void prePersist(){
		fechacreacion = new Date();
	}
	
	
	public Date getFechacreacion() {
		return fechacreacion;   
	}

//esa seria la relacion entre usuario

	public void setFechacreacion(Date fechacreacion) {
	this.fechacreacion = fechacreacion;
	}


	@ManyToOne(fetch=FetchType.LAZY)
	private Funcionario funcionario;
	
	@ManyToOne(fetch=FetchType.LAZY) 
	private Usuario usuario; 
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	private TipoFormulario tipoFormulario; 
	
	
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

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public String getTipoDeLicencia() { 
		return tipoDeLicencia;
	}

	public void setTipoDeLicencia(String tipoDeLicencia) {
		this.tipoDeLicencia = tipoDeLicencia;
	}

	public Long getTiempo() {
		return tiempo;
	}

	public void setTiempo(Long tiempo) {
		this.tiempo = tiempo;
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

	public String getDeHora() {
		return deHora;
	}

	public void setDeHora(String deHora) {
		this.deHora = deHora;
	}

	public String getaHora() {
		return aHora;
	}

	public void setaHora(String aHora) {
		this.aHora = aHora;
	}

	public Date getFechaRetorno() {
		return fechaRetorno;
	}

	public void setFechaRetorno(Date fechaRetorno) {
		this.fechaRetorno = fechaRetorno;
	}

	public int getGestion() {
		return gestion;
	}

	public void setGestion(int gestion) {
		this.gestion = gestion;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Long getComprobanteId() {
		return comprobanteId;
	}

	public void setComprobanteId(Long comprobanteId) {
		this.comprobanteId = comprobanteId;
	}

	public Long getPdfId() {
		return pdfId;
	}

	public void setPdfId(Long pdfId) {
		this.pdfId = pdfId;
	}

	public String getObservaciones() {
		return observaciones;
	}
	
	
	public String getTipoF() { 
		return tipoF;
	}


	public void setTipoF(String tipoF) {
		this.tipoF = tipoF;
	}


	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	private static final long serialVersionUID = 1L;
}
