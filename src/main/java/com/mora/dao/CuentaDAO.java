package com.mora.dao;

import java.util.List;

import com.mora.modelos.Cuentas;
import com.mora.modelos.Login;
import com.mora.modelos.Plan;

public interface CuentaDAO {
	
	
	public List<Cuentas> consultar();
	public Plan buscar(int id);
	public void desactivar(int id, int activa);
	public void modificar(int id, Cuentas cuentas);
	public int insertar(Cuentas nuevo_plan, int idPlan);
	public void modificarPlan(int id, int idPlan);
	
	public Cuentas loginC(Login login);
	Cuentas findUsuarioByNombre(String email);
}
