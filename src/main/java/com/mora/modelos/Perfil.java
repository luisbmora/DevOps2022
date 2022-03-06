package com.mora.modelos;

public class Perfil {
	
	private int id;
	private String nombre;
	private String idioma; 
	private String clasificacion_edad; 
	private  int cuentas_id;
	private int activo;
	public int getActivo() {
		return activo;
	}

	public void setActivo(int activo) {
		this.activo = activo;
	}

	
	public Perfil() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public String getClasificacion_edad() {
		return clasificacion_edad;
	}

	public void setClasificacion_edad(String clasificacion_edad) {
		this.clasificacion_edad = clasificacion_edad;
	}

	public int getCuentas_id() {
		return cuentas_id;
	}

	public void setCuentas_id(int cuentas_id) {
		this.cuentas_id = cuentas_id;
	}

	

	public Perfil(int id, String nombre, String idioma, String clasificacion_edad, int cuentas_id, int activo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.idioma = idioma;
		this.clasificacion_edad = clasificacion_edad;
		this.cuentas_id = cuentas_id;
		this.activo = activo;
	}

	@Override
	public String toString() {
		return "Perfil [id=" + id + ", nombre=" + nombre + ", idioma=" + idioma + ", clasificacion_edad="
				+ clasificacion_edad + ", cuentas_id=" + cuentas_id + "]";
	}
	
	
}
