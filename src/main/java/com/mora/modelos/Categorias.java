package com.mora.modelos;

import java.util.Date;

public class Categorias {
	private int id, activo;
	private String clasificacion, descripcion;
	private Date creado,modificado,eliminado;
	
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
