package com.mora.modelos;

public class Respuesta {
	private String mensaje;
	private String estatus;
	private Object object;
	private String descripcionError;
	private String token;
	
	
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public String getDescripcionError() {
		return descripcionError;
	}
	@Override
	public String toString() {
		return "Respuesta [mensaje=" + mensaje + ", estatus=" + estatus + ", object=" + object + ", descripcionError="
				+ descripcionError + "]";
	}
	public void setDescripcionError(String descripcionError) {
		this.descripcionError = descripcionError;
	}
	public String getEstatus() {
		return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	
	public Object getObject() {
		return object;
	}
	public void setObject(Object object) {
		this.object = object;
	}
	public Respuesta() {
		super();
			
		}
	//se llamaea si hay un erroir	
	public Respuesta(String mensaje,  String descripcionError, String estatus) {
		super();
		this.mensaje = mensaje;
		this.descripcionError = descripcionError;
		this.estatus = estatus;
	}
	
	
	//se llamara si todo esta bien
	public Respuesta(String mensaje, String descripcionError, String estatus, Object object) {
		super();
		this.mensaje = mensaje;
		this.descripcionError = descripcionError;
		this.estatus = estatus;
		this.object = object;
	}
	
	public Respuesta(String estatus, Object object) {
		super();
		this.estatus = estatus;
		this.object = object;
	}
	

	public Respuesta(String mensaje, String estatus, Object object) {
		super();
		this.mensaje = mensaje;
		this.estatus = estatus;
		this.object = object;
	}
	public Respuesta(String mensaje, String estatus, Object object, String descripcionError, String token) {
		super();
		this.mensaje = mensaje;
		this.estatus = estatus;
		this.object = object;
		this.descripcionError = descripcionError;
		this.token = token;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
	
	
}
