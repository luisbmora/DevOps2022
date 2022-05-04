package com.mora.modelos;



public class Cuentas {
	
	private int id;
	private String email;
	private String password;
	private int activa;
	private String fecha_ultimo_pago;
	private String nombre;
	private String apellido;
	private String numero_tarjeta;
	private String fecha_vencimiento;
	private String codigo_seguridad;
	private String tipo_tarjeta;
	private int planes_id;
	
	
	public Cuentas(int id, String email, String password, int activa, String fecha_ultimo_pago, String nombre,
			String apellido, String numero_tarjeta, String fecha_vencimiento, String codigo_seguridad,
			String tipo_tarjeta, int planes_id) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.activa = activa;
		this.fecha_ultimo_pago = fecha_ultimo_pago;
		this.nombre = nombre;
		this.apellido = apellido;
		this.numero_tarjeta = numero_tarjeta;
		this.fecha_vencimiento = fecha_vencimiento;
		this.codigo_seguridad = codigo_seguridad;
		this.tipo_tarjeta = tipo_tarjeta;
		this.planes_id = planes_id;
	}
	
	
	public Cuentas() {
		// TODO Auto-generated constructor stub
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getActiva() {
		return activa;
	}
	public void setActiva(int activa) {
		this.activa = activa;
	}
	public String getFecha_ultimo_pago() {
		return fecha_ultimo_pago;
	}
	public void setFecha_ultimo_pago(String fecha_ultimo_pago) {
		this.fecha_ultimo_pago = fecha_ultimo_pago;
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
	public String getNumero_tarjeta() {
		return numero_tarjeta;
	}
	public void setNumero_tarjeta(String numero_tarjeta) {
		this.numero_tarjeta = numero_tarjeta;
	}
	public String getFecha_vencimiento() {
		return fecha_vencimiento;
	}
	public void setFecha_vencimiento(String fecha_vencimiento) {
		this.fecha_vencimiento = fecha_vencimiento;
	}
	public String getCodigo_seguridad() {
		return codigo_seguridad;
	}
	public void setCodigo_seguridad(String codigo_seguridad) {
		this.codigo_seguridad = codigo_seguridad;
	}
	public String getTipo_tarjeta() {
		return tipo_tarjeta;
	}
	public void setTipo_tarjeta(String tipo_tarjeta) {
		this.tipo_tarjeta = tipo_tarjeta;
	}
	public int getPlanes_id() {
		return planes_id;
	}
	public void setPlanes_id(int planes_id) {
		this.planes_id = planes_id;
	}
	@Override
	public String toString() {
		return "Cuentas [id=" + id + ", email=" + email + ", password=" + password + ", activa=" + activa
				+ ", fecha_ultimo_pago=" + fecha_ultimo_pago + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", numero_tarjeta=" + numero_tarjeta + ", fecha_vencimiento=" + fecha_vencimiento
				+ ", codigo_seguridad=" + codigo_seguridad + ", tipo_tarjeta=" + tipo_tarjeta + ", planes_id="
				+ planes_id + "]";
	}

}

// luisRafa
