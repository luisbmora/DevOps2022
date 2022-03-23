package com.mora.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mora.dao.GenerosDAO;
import com.mora.modelos.Generos;

@Service
public class GenerosLogica implements GenerosService{

	@Autowired
	GenerosDAO repositorio;

	@Override
	public List<Generos> consultar() {
		return repositorio.consultar();
	}

	@Override
	public Generos buscar(int id) {
		return repositorio.buscar(id);
	}

	@Override
	public void desactivar(int id, int activo) {
		 repositorio.desactivar(id, activo);
	}

	@Override
	public void modificar(int id, Generos generos) {
		 repositorio.modificar(id, generos);
	}

	@Override
	public int insertar(Generos nuevo_genero) {
		return repositorio.insertar(nuevo_genero);
	}
}