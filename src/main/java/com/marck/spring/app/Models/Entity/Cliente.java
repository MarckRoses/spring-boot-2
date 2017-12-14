package com.marck.spring.app.Models.Entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class Cliente implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id; 
	private String nombre;
	private String apellido;
	private String email;
	private Timestamp fecha;
	public Cliente() {
		super();
	}
	public Cliente(Long id) {
		super();
		this.id = id;
	}
	public Long getId() {
		System.out.println("HolaMundo");
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
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Timestamp getFecha() {
		return fecha;
	}
	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}
}
