package com.mora.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mora.dao.PerfilesDAO;
import com.mora.modelos.Perfil;

@Service
public class PerfilLogica implements PerfilesService{

	@Autowired
	PerfilesDAO repositorio;

	@Override
	public List<Perfil> consultar() {
		return repositorio.consultar();
	}

	@Override
	public Perfil buscar(int id) {
		return repositorio.buscar(id);
	}

	@Override
	public void desactivar(int id, int activo) {
		 repositorio.desactivar(id, activo);
	}

	@Override
	public void modificar(int id, Perfil perfil) {
		 repositorio.modificar(id, perfil);
	}

	@Override
	public int insertar(Perfil nuevo_perfil, int idCuenta) {
		return repositorio.insertar(nuevo_perfil, idCuenta);
	}

	@Override
	public List<Perfil> buscarPorCuenta(int id) {
		// TODO Auto-generated method stub
		return repositorio.buscarPorCuenta(id);
	}
	
	
}
