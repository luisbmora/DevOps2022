package com.mora.service;

import java.util.List;

import com.mora.modelos.Actores;
import com.mora.modelos.Cuentas;

public interface ActoresService {
	
	
	public List<Actores> consultar();
	public Actores buscar(int id);
	public void desactivar(int id, int activo);
	public void modificar(int id, Actores actores);
	public int insertar(Actores nuevo_actor, int idActor);
}