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
				+ "activo = ? "
				+ "WHERE id = ? ";
		conexion.update(sql,
				activo,//quitar si se tiene que eliminar 
				id);
	}

	@Override
	public void modificar(int id, Categorias categorias) {
		String sql= "UPDATE categorias SET "
				+ "clasificacion = ?, "
				+ "descripcion = ?,"
				+ "activo = ? "
				+ " WHERE id = ?";
		conexion.update(sql, 
				categorias.getClasificacion(), 
				categorias.getDescripcion(),
				categorias.getActivo(),  
				id);
	}
	
	@Override
	public int insertar(Categorias nueva_categoria) {
		SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(conexion);
        //System.out.println(nuevo_plan.toString()+ " hay que ver");
        
		List<String> columnas = new ArrayList<>();
		columnas.add("clasificacion");
		columnas.add("descripcion");
        columnas.add("activo");
        simpleJdbcInsert.setTableName("categorias");
        simpleJdbcInsert.setColumnNames(columnas);
        
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("clasificacion", nueva_categoria.getClasificacion());
        parameters.put("descripcion", nueva_categoria.getDescripcion());
        parameters.put("activo", nueva_categoria.getActivo());
        
        simpleJdbcInsert.setGeneratedKeyName("id");   
        
        int id = simpleJdbcInsert.executeAndReturnKey(parameters).intValue();
        
		return id;
	}
}
