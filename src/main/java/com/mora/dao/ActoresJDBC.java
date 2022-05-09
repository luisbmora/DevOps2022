package com.mora.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.mora.modelos.Actores;
import com.mora.modelos.Perfil;

@Repository
public class ActoresJDBC implements ActoresDAO {
	
	@Autowired
	private JdbcTemplate conexion;

	@Override
	public List<Actores> consultar() {
		String sql = "SELECT * FROM actores ";
		return conexion.query(sql, new ActoresRM());
	}

	@Override
	public Actores buscar(int id) {
		String sql = "SELECT * FROM actores WHERE id=?";
		return conexion.queryForObject(sql, new ActoresRM(), id);
	}
	
	@Override
	public void desactivar(int id) {
		//String sql = "DELETE FROM actores WHERE id = ? ";
		String sql = "UPDATE actores SET "
				+ "activo = 0, "
				+ "eliminado = NOW()"
				+ "WHERE id = ? ";
		conexion.update(sql, 
				id);
	}

	@Override
	public void modificar(int id, Actores actores) {
		String sql= "UPDATE actores SET "
				+ "nombre_completo = ? "
				+ " WHERE id = ?";
		conexion.update(sql, 
				actores.getNombre_completo(), 
				id);
	}
	
	@Override
	public int insertar(Actores nuevo_actor) {
		String sql = "INSERT INTO actores (nombre_completo) VALUES (?)";
		conexion.update(sql,
				nuevo_actor.getNombre_completo());
		sql = "SELECT LAST_INSERT_ID()";
		return conexion.queryForObject(sql, Integer.class);
	}
}

// un comentario cualquiera
