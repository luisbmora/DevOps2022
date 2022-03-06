package com.mora.service;

import java.util.List;

import com.mora.modelos.Plan;

public interface PlanService {
	public List<Plan> consultar();
	public Plan buscar(int id);
	public void desactivar(int id);
	public void modificar(int id, Plan plan);
	public void insertar(Plan nuevo_plan);

}
