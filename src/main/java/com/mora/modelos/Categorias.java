package com.mora.modelos;

public class Categorias {
	private int id, activo;
	private String clasificacion, descripcion;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getActivo() {
		return activo;
	}
	
	public Categorias() {
		// TODO Auto-generated constructor stub
	}
	public void setActivo(int activo) {
		this.activo = activo;
	}
	public String getClasificacion() {
		return clasificacion;
	}
	public void setClasificacion(String clasificacion) {
		this.clasificacion = clasificacion;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
