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
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="personas")
public class Persona implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
    // sin restricciones
	@Column(nullable=false)
	private String nombres;//
	private String paterno;
	private String materno;
	private String profesion;
	private String apellidoCasada;
	private String fotoId;
	private String numeroDocumento;//unique
	private String tipoDocumento;
	private String expedicion;
	private String archivoDoc;
	private String sexo;
	private String estadoCivil;
	
	private Date fechaNacimiento;
	private String nacPais;
	private String nacDepartamento;
	private String nacLocalidad;
	private String nacProvincia;
	private String numeroDeDependencia;
	private String nacionalidad;
	private Long nacDoc;
	private String direccion;
	private String resPais;
	private String resDepartamento;
	private String resLocalidad;
	private String resProvincia;
	private String telfDomi;
	private String telfTrabajo;
	private String fax;
	private String cel;
	@Column(nullable=false, unique = true)
	private String correo;//
	private boolean exiteRelacionParentesco;
	private String nombreCompletoPariente;
	private String relacionFamiliar;
	private String gradoParentesco;
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



	public void setFechacreacion(Date fechacreacion) {
	this.fechacreacion = fechacreacion;
	}


    //Relacion de uno a muchos hoja de vida
	///Relacion de uno a muchos funcionario


	@OneToMany(fetch=FetchType.LAZY, mappedBy="persona", cascade=CascadeType.ALL)
	private List <HojaDeVida> hojaDeVidas;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="persona", cascade=CascadeType.ALL)
	// @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
	private List <Funcionario> funcionarios;
	
	public Persona() {
		this.hojaDeVidas = new ArrayList<>();
		this.funcionarios = new ArrayList<>();
	}
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getPaterno() {
		return paterno;
	}
	public void setPaterno(String paterno) {
		this.paterno = paterno;
	}
	public String getMaterno() {
		return materno;
	}
	public void setMaterno(String materno) {
		this.materno = materno;
	}
	public String getProfesion() {
		return profesion;
	}
	public void setProfesion(String profesion) {
		this.profesion = profesion;
	}
	public String getApellidoCasada() {
		return apellidoCasada;
	}
	public void setApellidoCasada(String apellidoCasada) {
		this.apellidoCasada = apellidoCasada;
	}
	public String getFotoId() {
		return fotoId;
	}
	public void setFotoId(String fotoId) {
		this.fotoId = fotoId;
	}
	public String getNumeroDocumento() {
		return numeroDocumento;
	}
	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}
	public String getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	public String getExpedicion() {
		return expedicion;
	}
	public void setExpedicion(String expedicion) {
		this.expedicion = expedicion;
	}
	public String getArchivoDoc() {
		return archivoDoc;
	}
	public void setArchivoDoc(String archivoDoc) {
		this.archivoDoc = archivoDoc;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getEstadoCivil() {
		return estadoCivil;
	}
	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getNacPais() {
		return nacPais;
	}
	public void setNacPais(String nacPais) {
		this.nacPais = nacPais;
	}
	public String getNacDepartamento() {
		return nacDepartamento;
	}
	public void setNacDepartamento(String nacDepartamento) {
		this.nacDepartamento = nacDepartamento;
	}
	public String getNacLocalidad() {
		return nacLocalidad;
	}
	public void setNacLocalidad(String nacLocalidad) {
		this.nacLocalidad = nacLocalidad;
	}
	public String getNacProvincia() {
		return nacProvincia;
	}
	public void setNacProvincia(String nacProvincia) {
		this.nacProvincia = nacProvincia;
	}
	public String getNumeroDeDependencia() {
		return numeroDeDependencia;
	}
	public void setNumeroDeDependencia(String numeroDeDependencia) {
		this.numeroDeDependencia = numeroDeDependencia;
	}
	public String getNacionalidad() {
		return nacionalidad;
	}
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	public Long getNacDoc() {
		return nacDoc;
	}
	public void setNacDoc(Long nacDoc) {
		this.nacDoc = nacDoc;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getResPais() {
		return resPais;
	}
	public void setResPais(String resPais) {
		this.resPais = resPais;
	}
	public String getResDepartamento() {
		return resDepartamento;
	}
	public void setResDepartamento(String resDepartamento) {
		this.resDepartamento = resDepartamento;
	}
	public String getResLocalidad() {
		return resLocalidad;
	}
	public void setResLocalidad(String resLocalidad) {
		this.resLocalidad = resLocalidad;
	}
	public String getResProvincia() {
		return resProvincia;
	}
	public void setResProvincia(String resProvincia) {
		this.resProvincia = resProvincia;
	}
	public String getTelfDomi() {
		return telfDomi;
	}
	public void setTelfDomi(String telfDomi) {
		this.telfDomi = telfDomi;
	}
	public String getTelfTrabajo() {
		return telfTrabajo;
	}
	public void setTelfTrabajo(String telfTrabajo) {
		this.telfTrabajo = telfTrabajo;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getCel() {
		return cel;
	}
	public void setCel(String cel) {
		this.cel = cel;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public boolean isExiteRelacionParentesco() {
		return exiteRelacionParentesco;
	}
	public void setExiteRelacionParentesco(boolean exiteRelacionParentesco) {
		this.exiteRelacionParentesco = exiteRelacionParentesco;
	}
	public String getNombreCompletoPariente() {
		return nombreCompletoPariente;
	}
	public void setNombreCompletoPariente(String nombreCompletoPariente) {
		this.nombreCompletoPariente = nombreCompletoPariente;
	}
	public String getRelacionFamiliar() {
		return relacionFamiliar;
	}
	public void setRelacionFamiliar(String relacionFamiliar) {
		this.relacionFamiliar = relacionFamiliar;
	}
	public String getGradoParentesco() {
		return gradoParentesco;
	}
	public void setGradoParentesco(String gradoParentesco) {
		this.gradoParentesco = gradoParentesco;
	}
	
	
	///hoja de vida 
	public List<HojaDeVida> getHojaDeVidas() {
		return hojaDeVidas;
	}

	public void setHojaDeVidas(List<HojaDeVida> hojaDeVidas) {
		this.hojaDeVidas = hojaDeVidas;
	}

	
	///funcionario
	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}
	
	
	
	
	
	private static final long serialVersionUID = 1L;
}
