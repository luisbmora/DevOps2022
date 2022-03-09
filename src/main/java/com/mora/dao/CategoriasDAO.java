package com.mora.dao;

import java.util.List;

import com.mora.modelos.Categorias;

public interface CategoriasDAO {
	public List<Categorias> consultar();
	public Categorias buscar(int id);
	public void desactivar(int id, int activo);
	public void modificar(int id, Categorias actores);
	public int insertar(Categorias nueva_categoria);

}
