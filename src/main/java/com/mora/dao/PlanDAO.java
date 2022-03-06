package com.mora.dao;

import java.util.List;

import com.mora.modelos.Plan;


public interface PlanDAO {
	
	public List<Plan> consultar();
	public Plan buscar(int id);
	public void desactivar(int id);
	public void modificar(int id, Plan plan);
	public int insertar(Plan nuevo_plan);

}
