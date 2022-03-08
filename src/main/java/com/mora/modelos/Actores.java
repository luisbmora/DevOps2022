package com.mora.modelos;

public class Actores {
	
	private int id;
	private String nombre_completo;
	private int activo;
	public int getActivo() {
		return activo;
	}

	public void setActivo(int activo) {
		this.activo = activo;
	}

		
	public Actores() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre_completo;
	}

	public void setNombre(String nombre_completo) {
		this.nombre_completo = nombre_completo;
	}
	

	public Actores(int id, String nombre_completo) {
		super();
		this.id = id;
		this.nombre_completo = nombre_completo;
			}

	@Override
	public String toString() {
		return "Actores [id=" + id + ", nombre=" + nombre_completo + "]";
	}
	
	
}

