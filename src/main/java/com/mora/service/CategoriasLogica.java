package com.mora.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mora.dao.CategoriasDAO;
import com.mora.modelos.Categorias;

@Service
public class CategoriasLogica  implements CategoriasService{
	@Autowired
	CategoriasDAO repositorio;

	@Override
	public List<Categorias> consultar() {
		return repositorio.consultar();
	}

	@Override
	public Categorias buscar(int id) {
		return repositorio.buscar(id);
	}

	@Override
	public void desactivar(int id, int activo) {
		 repositorio.desactivar(id, activo);
	}

	@Override
	public void modificar(int id, Categorias categorias) {
		 repositorio.modificar(id, categorias);
	}

	@Override
	public int insertar(Categorias nueva_categorias) {
		return repositorio.insertar(nueva_categorias);
	}
}
