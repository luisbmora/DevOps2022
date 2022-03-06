package com.mora.dao;

import java.util.List;

import com.mora.modelos.Perfil;

public interface PerfilesDAO {
	
	public List<Perfil> consultar();
	public Perfil buscar(int id);
	public List<Perfil> buscarPorCuenta(int id);
	public void desactivar(int id, int activo);
	public void modificar(int id, Perfil perfil);
	public int insertar(Perfil nuevo_perfil, int idCuenta);
}
