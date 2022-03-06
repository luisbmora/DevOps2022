package com.mora.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mora.dao.PlanDAO;
import com.mora.modelos.Plan;


@Service
public class PlanLogica implements PlanService{
	
	@Autowired
	PlanDAO repositorio;

	@Override
	public List<Plan> consultar() {
		// TODO Auto-generated method stub
		return repositorio.consultar();
	}

	@Override
	public Plan buscar(int id) {
		// TODO Auto-generated method stub
		return repositorio.buscar(id);
	}

	@Override
	public void desactivar(int id) {
		// TODO Auto-generated method stub
		repositorio.desactivar(id);
		
	}

	@Override
	public void modificar(int id, Plan plan) {
		// TODO Auto-generated method stub
		repositorio.modificar(id, plan);
		
	}

	@Override
	public void insertar(Plan nuevo_plan) {
		// TODO Auto-generated method stub
		 repositorio.insertar(nuevo_plan);
		
	}

	

}
