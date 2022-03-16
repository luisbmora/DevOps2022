package com.mora.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mora.modelos.Actores;

public class ActoresRM  implements RowMapper<Actores>{
		
	
	@Override
	public Actores mapRow(ResultSet rs, int rowNum) throws SQLException{
		Actores  actores =  new Actores();
		actores.setId(rs.getInt("id"));
		actores.setNombre_completo(rs.getString("nombre_completo"));
		actores.setActivo(rs.getInt("activo"));
		actores.setCreado(rs.getDate("creado"));
		actores.setModificado(rs.getDate("modificado"));
		actores.setEliminado(rs.getDate("eliminado"));
		return actores;
	}
}