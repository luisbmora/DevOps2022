package com.mora.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.mora.modelos.Categorias;

@Repository
public class CategoriasJDBC implements CategoriasDAO {
	@Autowired
	private JdbcTemplate conexion;

	@Override
	public List<Categorias> consultar() {
		String sql = "SELECT * FROM categorias ";
		return conexion.query(sql, new CategoriasRM());
	}

	@Override
	public Categorias buscar(int id) {
		String sql = "SELECT * FROM categorias WHERE id=?";
		return conexion.queryForObject(sql, new CategoriasRM(), id);
	}
	
	@Override
	public void desactivar(int id, int activo) {
		//String sql = "DELETE FROM categorias WHERE id = ? ";
		String sql = "UPDATE categorias SET "
				+ "activo = 0 ,"
				+ "eliminado = NOW()"
				+ "WHERE id = ? ";
		conexion.update(sql,
				id);
	}

	@Override
	public void modificar(int id, Categorias categorias) {
		String sql= "UPDATE categorias SET "
				+ "clasificacion = ?, "
				+ "descripcion = ?"
				+ " WHERE id = ?";
		conexion.update(sql, 
				categorias.getClasificacion(), 
				categorias.getDescripcion(), 
				id);
	}
	
	@Override
	public int insertar(Categorias nueva_categoria) {
		String sql = "INSERT INTO categorias (clasificacion, descripcion) VALUES (?,?)";
		conexion.update(sql,
				nueva_categoria.getClasificacion(),
				nueva_categoria.getDescripcion());
		sql = "SELECT LAST_INSERT_ID()";
		return conexion.queryForObject(sql, Integer.class);	}
}
