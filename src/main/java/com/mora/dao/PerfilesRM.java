package com.mora.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mora.modelos.Perfil;
import com.mora.modelos.Plan;

public class PerfilesRM  implements RowMapper<Perfil>{
		
	
	@Override
	public Perfil mapRow(ResultSet rs, int rowNum) throws SQLException{
		Perfil  perfil =  new Perfil();
		perfil.setId(rs.getInt("id"));
		perfil.setNombre(rs.getString("nombre"));
		perfil.setIdioma(rs.getString("idioma"));
		perfil.setClasificacion_edad(rs.getString("clasificacion_edad"));
		perfil.setCuentas_id(rs.getInt("cuentas_id"));
		perfil.setActivo(rs.getInt("activo"));
		return perfil;
	}
}
