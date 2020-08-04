package com.ezequiel.microwithSB.Usuarios;

public class User {
	private Integer id;
	private String name;
	private String dni;
	public User(Integer id, String name, String dni) {
		super();
		this.id = id;
		this.name = name;
		this.dni = dni;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
}
