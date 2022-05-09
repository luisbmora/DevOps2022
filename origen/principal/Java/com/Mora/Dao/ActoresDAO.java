package com.mora.dao;

import java.util.List;

import com.mora.modelos.Actores;

public interface ActoresDAO {
	
	public List<Actores> consultar();
	public Actores buscar(int id);
	public void desactivar(int id);
	public void modificar(int id, Actores actores);
	public int insertar(Actores nuevo_actor);
}
// primer intento 1.1.1
