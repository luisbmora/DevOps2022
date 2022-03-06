package com.mora.service;

import java.util.List;

import com.mora.modelos.Cuentas;
import com.mora.modelos.Login;
import com.mora.modelos.Plan;
import com.mora.modelos.Respuesta;

public interface CuentaService {

	public List<Cuentas> consultar();
	public Cuentas buscar(int id);
	public void desactivar(int id, int activa);
	public void modificar(int id, Cuentas plan);
	public void insertar(Cuentas nuevo_plan, int idPlan);
	public void modificarPlan(int id, int idPlan);
	
	public Respuesta loginC(Login login);
}
