package com.mora.modelos;

import java.util.Date;

public class Generos {
	private int id, activo;
	private String nombre;
	private Date creado, modificado, eliminado;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getActivo() {
		return activo;
	}
	public void setActivo(int activo) {
		this.activo = activo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Date getCreado() {
		return creado;
	}
	public void setCreado(Date creado) {
		this.creado = creado;
	}
	public Date getModificado() {
		return modificado;
	}
	public void setModificado(Date modificado) {
		this.modificado = modificado;
	}
	public Date getEliminado() {
		return eliminado;
	}
	public void setEliminado(Date eliminado) {
		this.eliminado = eliminado;
	}
	
	
}
