package com.mora.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mora.dao.CuentaDAO;
import com.mora.dao.PlanDAO;
import com.mora.modelos.Cuentas;
import com.mora.modelos.Login;
import com.mora.modelos.Respuesta;


@Service
public class CuentaLogica implements CuentaService{
	
	@Autowired
	 CuentaDAO repositorio;

	@Override
	public List<Cuentas> consultar() {
		// TODO Auto-generated method stub
		return repositorio.consultar();
	}

	@Override
	public Cuentas buscar(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void desactivar(int id, int activa) {
		repositorio.desactivar(id, activa);
		
	}

	@Override
	public void modificar(int id, Cuentas cuentas) {
		repositorio.modificar(id, cuentas);
		
	}

	@Override
	public void insertar(Cuentas nuevo_plan, int idPlan) {
		repositorio.insertar(nuevo_plan, idPlan);
		
	}

	@Override
	public void modificarPlan(int id, int idPlan) {
		repositorio.modificarPlan(id, idPlan);
	}

	@Override
	public Respuesta loginC(Login login) {
		Respuesta res = new Respuesta();
		res.setObject(repositorio.loginC(login));
		/*try {
			res.setToken(jtw.cretaJWT(repositorio.loginC(login)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		return res;
	}

	

}
