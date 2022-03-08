package com.mora.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mora.dao.ActoresDAO;
import com.mora.modelos.Actores;

@Service
public class ActoresLogica implements ActoresService{

	@Autowired
	ActoresDAO repositorio;

	@Override
	public List<Actores> consultar() {
		return repositorio.consultar();
	}

	@Override
	public Actores buscar(int id) {
		return repositorio.buscar(id);
	}

	@Override
	public void desactivar(int id, int activo) {
		 repositorio.desactivar(id, activo);
	}

	@Override
	public void modificar(int id, Actores actores) {
		 repositorio.modificar(id, actores);
	}

	@Override
	public int insertar(Actores nuevo_actor, int idActor) {
		return repositorio.insertar(nuevo_actor, idActor);
	}

	
	
}
