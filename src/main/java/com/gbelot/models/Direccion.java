package com.gbelot.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name ="direccion")
public class Direccion {

	@Id
	@Column(name="id_direccion")
	private Long id;
	
	@Column()
	private String direccion;
	
	@Column()
	private String departamento;
	
	@Column()
	private String municipio;
	
	@Column()
	private String pais;
	
	@OneToOne(mappedBy = "direccion", fetch = FetchType.LAZY)
	private Empledo empledo; 
	
	public Direccion() {}

	public Direccion(Long id, String direccion, String departamento, String municipio, String pais) {
		this.id = id;
		this.direccion = direccion;
		this.departamento = departamento;
		this.municipio = municipio;
		this.pais = pais;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}
	
	public Empledo getEmpledo() {
		return empledo;
	}

	public void setEmpledo(Empledo empledo) {
		this.empledo = empledo;
	}

	@Override
	public String toString() {
		return "Direccion [id=" + id + ", direccion=" + direccion + ", departamento=" + departamento + ", municipio="
				+ municipio + ", pais=" + pais + ", empledo=" + empledo.getCodigo() + "]";
	}
	
	
	
	
	
}
