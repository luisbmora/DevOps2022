package com.mora.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.mora.modelos.Generos;

@Repository
public class GenerosJDBC implements GenerosDAO {
	@Autowired
	private JdbcTemplate conexion;

	@Override
	public List<Generos> consultar() {
		String sql = "SELECT * FROM generos ";
		return conexion.query(sql, new GenerosRM());
	}

	@Override
	public Generos buscar(int id) {
		String sql = "SELECT * FROM generos WHERE id=?";
		return conexion.queryForObject(sql, new GenerosRM(), id);
	}
	
	@Override
	public void desactivar(int id, int activo) {
		//String sql = "DELETE FROM Generos WHERE id = ? ";
		String sql = "UPDATE generos SET "
				+ "activo = 0 ,"
				+ "eliminado = NOW()"
				+ "WHERE id = ? ";
		conexion.update(sql,
				id);
	}

	@Override
	public void modificar(int id, Generos generos) {
		String sql= "UPDATE generos SET "
				+ "nombre = ?, modificado = NOW()"
				+ " WHERE id = ?";
		conexion.update(sql, 
				generos.getNombre(),  
				id);
	}
	
	@Override
	public int insertar(Generos nuevo_genero) {
		String sql = "INSERT INTO generos (nombre) VALUES (?)";
		conexion.update(sql,
				nuevo_genero.getNombre());
		sql = "SELECT LAST_INSERT_ID()";
		return conexion.queryForObject(sql, Integer.class);	}
}

