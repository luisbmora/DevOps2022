package com.mora.REST;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mora.modelos.Cuentas;
import com.mora.modelos.Login;
import com.mora.modelos.Perfil;
import com.mora.modelos.Respuesta;
import com.mora.service.CuentaService;

import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RequestMapping("/cuentas")
@RestController
public class LoginREST {
	
	Logger log = LoggerFactory.getLogger(LoginREST.class);
	
	@Autowired
	CuentaService cs;
	
	@PostMapping
	@ApiOperation(value="Login", response=CuentaREST[].class)
	public ResponseEntity<Respuesta> crearCliente( @RequestBody Login login) {
		Respuesta resp = new Respuesta();
		Cuentas cuentas = new Cuentas();
		//log.info(plan.getDescripcion()+ " jhdkjshdfkljshd");
		try {
			resp = cs.loginC(login);
		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
			resp.setDescripcionError("no se encuenta alv");
			resp.setEstatus("ERROR");
			resp.setMensaje("Ocurrió un problema al hacer login");
			return new ResponseEntity<>(resp, HttpStatus.NOT_FOUND);
		}
		resp.setEstatus("OK");
		resp.setMensaje("");
		return new ResponseEntity<>(resp, HttpStatus.CREATED);
	}

}
