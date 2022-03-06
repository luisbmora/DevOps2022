package com.mora.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.mora.modelos.Plan;



@Repository
public class PlanJDBC implements PlanDAO{
	
	@Autowired
	private JdbcTemplate conexion;
	
	public List<Plan> consultar(){
		String sql = "SELECT * FROM planes ";
		return conexion.query(sql, new PlanRM());
	}

	public Plan buscar(int id) {
		String sql = "SELECT * FROM planes WHERE id=?";
		return conexion.queryForObject(sql, new PlanRM(), id);
	}

	public void desactivar(int id) {
		String sql = "UPDATE planes SET  eliminado=NOW() WHERE id =?";
		conexion.update(sql, id);
	}
	
	public void modificar(int id, Plan plan) {
		String sql = "UPDATE planes SET descripcion = ?, precio_mensual = ?,"
				+ "calidad_video = ?, resolucion= ?"
				+ "cantidad_dispositivos = ?, modificado = NOW()" 
				+ "WHERE id = ?";
		conexion.update(sql, plan.getDescripcion(), plan.getPrecio_mensual(), plan.getCalidad_video()
,						plan.getResolucion(), plan.getCantidad_dispositivos(), id);
	}
	
	public int insertar(Plan nuevo_plan) throws DataAccessException{
		
		SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(conexion);
		
        //System.out.println(nuevo_plan.toString()+ " hay que ver");
        
		List<String> columnas = new ArrayList<>();
		columnas.add("descripcion");
        columnas.add("precio_mensual");
        columnas.add("calidad_video");
        columnas.add("resolucion");
        columnas.add("cantidad_dispositivos");
        simpleJdbcInsert.setTableName("planes");
        simpleJdbcInsert.setColumnNames(columnas);
        
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("descripcion", nuevo_plan.getDescripcion());
        parameters.put("precio_mensual", nuevo_plan.getPrecio_mensual());
        parameters.put("calidad_video", nuevo_plan.getCalidad_video()); 
        parameters.put("resolucion", nuevo_plan.getResolucion());
        parameters.put("cantidad_dispositivos", nuevo_plan.getCantidad_dispositivos());
        
        simpleJdbcInsert.setGeneratedKeyName("id");   
        
        int id = simpleJdbcInsert.executeAndReturnKey(parameters).intValue();
        
		return id;
	}

}
