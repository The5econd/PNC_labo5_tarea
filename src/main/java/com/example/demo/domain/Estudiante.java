package com.example.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;


@Entity
@Table(schema="public", name="estudiante")
public class Estudiante {
	
	@Id
	@Column(name="c_usuario")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cUsuario;
	
	@Column(name="nombre")
	@NotEmpty(message="No puede ser vacio")
	private String nombre;
	
	@Column(name="apellido")
	@NotEmpty(message="No puede ser vacio")
	private String apellido;
	
	@Column(name="carne")
	@Pattern(regexp="^$|[0-9]{8}", message="8 digitos porfavor")
	@NotEmpty(message="No puede ser vacio")
	private String carne;
	
	@Column(name="carrera")
	@NotEmpty(message="no puede ser vacio")
	private String carrera;
	
	
	public Estudiante(){}


	public Integer getcUsuario() {
		return cUsuario;
	}


	public void setcUsuario(Integer cUsuario) {
		this.cUsuario = cUsuario;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getCarne() {
		return carne;
	}


	public void setCarne(String carne) {
		this.carne = carne;
	}


	public String getCarrera() {
		return carrera;
	}


	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}
	
	
	
	
}
