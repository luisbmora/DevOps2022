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
import org.springframework.security.crypto.password.PasswordEncoder;

import com.mora.modelos.Cuentas;
import com.mora.modelos.Login;
import com.mora.modelos.Plan;

@Repository
public class CuentaJDBS implements CuentaDAO{
	
	@Autowired
	private JdbcTemplate conexion;
	
	@Autowired
	PasswordEncoder encoder;

	@Override
	public List<Cuentas> consultar() {
		String sql = "SELECT * FROM cuentas ";
		return conexion.query(sql, new CuentaRM());
	}

	@Override
	public Plan buscar(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void desactivar(int id, int activa) {
		//String sql = "DELETE FROM `cuentas` WHERE id = ? "
		String sql = "UPDATE cuentas SET "
				+ "activa = ? "
				+ "WHERE id = ? ";
		conexion.update(sql,
				activa,//quitar si se tiene que eliminar 
				id);
	}

	@Override
	public void modificar(int id, Cuentas cuentas) {
		String sql = "UPDATE cuentas SET "
				+ "email = ?, "
				+ "password = ?, "
				+ "activa = ?, "
				+ "fecha_ultimo_pago = ?,"
				+ "nombre = ?,"
				+ "apellido = ?, "
				+ "numero_tarjeta = ?,"
				+ " fecha_vencimiento = ?, "
				+ "codigo_seguridad = ?, "
				+ "tipo_tarjeta = ?, "
				+ "planes_id = ? "
				+ "WHERE id = ? ";
		conexion.update(sql, cuentas.getEmail(), 
				cuentas.getPassword(), 
				cuentas.getActiva(),
				cuentas.getFecha_ultimo_pago(),
				cuentas.getNombre(),
				cuentas.getApellido(),
				cuentas.getNumero_tarjeta(),
				cuentas.getFecha_vencimiento(),
				cuentas.getCodigo_seguridad(),
				cuentas.getTipo_tarjeta(),
				cuentas.getPlanes_id(),
				id);
		
	}

	@Override
	public int insertar(Cuentas nuevo_plan, int idPlan) {
		//nuevo_plan.setPassword(encoder.encode(nuevo_plan.getPassword()));
		// TODO Auto-generated method stub
		SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(conexion);
		
		List<String> columnas = new ArrayList<>();
		
		columnas.add("email");
		columnas.add("password");
		columnas.add("activa");
		columnas.add("fecha_ultimo_pago");
		columnas.add("nombre");
		columnas.add("apellido");
		columnas.add("numero_tarjeta");
		columnas.add("fecha_vencimiento");
		columnas.add("codigo_seguridad");
		columnas.add("tipo_tarjeta");
		columnas.add("planes_id");
		
		simpleJdbcInsert.setTableName("cuentas");
		
		simpleJdbcInsert.setColumnNames(columnas);
		
		Map<String, Object> parameters = new HashMap<>();
		
		parameters.put("email", nuevo_plan.getEmail());
		parameters.put("password", nuevo_plan.getPassword());
		parameters.put("activa", nuevo_plan.getActiva());
		parameters.put("fecha_ultimo_pago", nuevo_plan.getFecha_ultimo_pago());
		parameters.put("nombre", nuevo_plan.getNombre());
		parameters.put("apellido", nuevo_plan.getApellido());
		parameters.put("numero_tarjeta", nuevo_plan.getNumero_tarjeta());
		parameters.put("fecha_vencimiento", nuevo_plan.getFecha_vencimiento());
		parameters.put("codigo_seguridad", nuevo_plan.getCodigo_seguridad());
		parameters.put("tipo_tarjeta", nuevo_plan.getTipo_tarjeta());
		parameters.put("planes_id", idPlan);
		
		simpleJdbcInsert.setGeneratedKeyName("id");
		
		int id = simpleJdbcInsert.executeAndReturnKey(parameters).intValue();
		
		return id;
	}

	@Override
	public void modificarPlan(int id, int idPlan) {
		String sql = "UPDATE cuentas SET "
				+ "planes_id = ? "
				+ "WHERE id = ? ";
		conexion.update(sql,
				idPlan,
				id);
	}

	@Override
	public Cuentas loginC(Login login)throws DataAccessException {
		String sql = "select * from cuentas where password = ? and email = ?";
		
		System.out.println(login.getEmail()+ "lkjlkjslñd "+login.getPassword());
		return conexion.queryForObject(sql,new CuentaRM(), login.getPassword(), login.getEmail());
	}

	@Override
	public Cuentas findUsuarioByNombre(String email) {
		String sql = "select * from cuentas where  email = ?";
		return conexion.queryForObject(sql,new CuentaRM(), email);
	}

	

}
