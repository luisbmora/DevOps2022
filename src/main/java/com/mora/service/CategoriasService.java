package com.mora.service;

import java.util.List;

import com.mora.modelos.Categorias;

public interface CategoriasService {
	public List<Categorias> consultar();
	public Categorias buscar(int id);
	public void desactivar(int id, int activo);
	public void modificar(int id, Categorias categorias);
	public int insertar(Categorias nueva_categorias);
}
