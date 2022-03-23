package com.mora.service;

import java.util.List;
import com.mora.modelos.Generos;

public interface GenerosService {	
		
		public List<Generos> consultar();
		public Generos buscar(int id);
		public void desactivar(int id, int activo);
		public void modificar(int id, Generos generos);
		public int insertar(Generos nuevo_genero);
	
}
