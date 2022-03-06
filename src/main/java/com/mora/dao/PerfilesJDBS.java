package com.mora.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.mora.modelos.Perfil;

@Repository
public class PerfilesJDBS implements PerfilesDAO {
	
	@Autowired
	private JdbcTemplate conexion;

	@Override
	public List<Perfil> consultar() {
		String sql = "SELECT * FROM perfiles_usuarios ";
		return conexion.query(sql, new PerfilesRM());
	}

	@Override
	public Perfil buscar(int id) {
		String sql = "SELECT * FROM perfiles_usuarios WHERE id=?";
		return conexion.queryForObject(sql, new PerfilesRM(), id);
	}
	
	

	@Override
	public void desactivar(int id, int activo) {
		//String sql = "DELETE FROM perfiles_usuarios WHERE id = ? ";
		String sql = "UPDATE perfiles_usuarios SET "
				+ "activo = ? "
				+ "WHERE id = ? ";
		conexion.update(sql,
				activo,//quitar si se tiene que eliminar 
				id);
	}

	@Override
	public void modificar(int id, Perfil perfil) {
		String sql= "UPDATE perfiles_usuarios SET "
				+ "nombre = ?, "
				+ "idioma = ?,"
				+ " clasificacion_edad = ?,"
				+ " cuentas_id = ?"
				+ " WHERE id = ?";
		conexion.update(sql, 
				perfil.getNombre(), 
				perfil.getIdioma(), 
				perfil.getClasificacion_edad(),
				perfil.getCuentas_id(), 
				id);
	}

	@Override
	public int insertar(Perfil nuevo_perfil, int idCuenta) {
		SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(conexion);
        //System.out.println(nuevo_plan.toString()+ " hay que ver");
        
		List<String> columnas = new ArrayList<>();
		columnas.add("nombre");
        columnas.add("idioma");
        columnas.add("clasificacion_edad");
        columnas.add("cuentas_id");
        columnas.add("activo");
        simpleJdbcInsert.setTableName("perfiles_usuarios");
        simpleJdbcInsert.setColumnNames(columnas);
        
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("nombre", nuevo_perfil.getNombre());
        parameters.put("idioma", nuevo_perfil.getIdioma());
        parameters.put("clasificacion_edad", nuevo_perfil.getClasificacion_edad()); 
        parameters.put("cuentas_id", idCuenta);
        parameters.put("activo", nuevo_perfil.getActivo());
        
        simpleJdbcInsert.setGeneratedKeyName("id");   
        
        int id = simpleJdbcInsert.executeAndReturnKey(parameters).intValue();
        
		return id;
	}

	@Override
	public List<Perfil> buscarPorCuenta(int id) {
		String sql = "SELECT * FROM perfiles_usuarios WHERE cuentas_id = ?";
		return conexion.query(sql, new PerfilesRM(), id);
	}
	
	
}
