package com.jribero.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name= "PERSONA")
@XmlRootElement(name="persona")
@XmlAccessorType(XmlAccessType.FIELD)
public class Persona {
	
	//Metodos
	@Id
	@Column(name = "documento", unique = true, length = 8)
	private String documento;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "apellido")
	private String apellido;
	
	@Column(name = "edad")
	private String edad;
	
	@Column(name = "email")
	private String email;
	
	
	//Constructor
	public Persona(String documento, String nombre, String apellido, String edad, String email) {
		this.documento = documento;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.email = email;
	}
	
	//Constructor por defecto
	public Persona() {
		
	}
	
	//Getters and Setters
	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
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

	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "Persona [documento=" + documento + ", nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad
				+ ", email=" + email + "]";
	}
}
