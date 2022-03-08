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
	public void desactivar(int id, int activo) {
		//String sql = "DELETE FROM actores WHERE id = ? ";
		String sql = "UPDATE actores SET "
				+ "activo = ? "
				+ "WHERE id = ? ";
		conexion.update(sql,
				activo,//quitar si se tiene que eliminar 
				id);
	}

	@Override
	public void modificar(int id, Actores actores) {
		String sql= "UPDATE actores SET "
				+ "nombre_completo = ?, "
				+ "activo = ?"
				+ " WHERE id = ?";
		conexion.update(sql, 
				actores.getNombre(), 
				actores.getActivo(),  
				id);
	}
	
	@Override
	public int insertar(Actores nuevo_actor, int idActores) {
		SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(conexion);
        //System.out.println(nuevo_plan.toString()+ " hay que ver");
        
		List<String> columnas = new ArrayList<>();
		columnas.add("nombre_completo");
        columnas.add("activo");
        simpleJdbcInsert.setTableName("actores");
        simpleJdbcInsert.setColumnNames(columnas);
        
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("nombre_completo", nuevo_actor.getNombre());
        parameters.put("activo", nuevo_actor.getActivo());
        
        simpleJdbcInsert.setGeneratedKeyName("id");   
        
        int id = simpleJdbcInsert.executeAndReturnKey(parameters).intValue();
        
		return id;
	}
}
