package com.mora.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mora.modelos.Generos;


public class GenerosRM implements RowMapper<Generos>{
	
	@Override
	public Generos mapRow(ResultSet rs, int rowNum) throws SQLException{
		Generos  genero =  new Generos();
		genero.setId(rs.getInt("id"));
		genero.setNombre(rs.getString("nombre"));
		return genero;
	}

}
