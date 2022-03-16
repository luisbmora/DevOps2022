package com.mora.modelos;

import java.util.Date;

public class Actores {
	

	private String nombre_completo;
	private Date creado,modificado,eliminado;
	private int activo;
	private int id;
	
	public String getNombre_completo() {
		return nombre_completo;
	}
	public void setNombre_completo(String nombre_completo) {
		this.nombre_completo = nombre_completo;
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
	public int getActivo() {
		return activo;
	}
	public void setActivo(int activo) {
		this.activo = activo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	
}

