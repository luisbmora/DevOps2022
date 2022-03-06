package com.mora.REST;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mora.modelos.Cuentas;
import com.mora.modelos.Login;
import com.mora.modelos.Respuesta;
import com.mora.security.JwtUtils;
import com.mora.security.UserDetailsImpl;
import com.mora.service.CuentaService;


@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	CuentaService cService;
	
	@Autowired
	JwtUtils jwtUtils;
	
	@Autowired
	CuentaService cs;
	
	@PostMapping("/login")
	public ResponseEntity<Respuesta> authenticateUser(@RequestBody Cuentas loginRequest) {
		
		Respuesta resp= new Respuesta();
		Login login = new Login();
		login.setEmail(loginRequest.getEmail());
		login.setPassword(loginRequest.getPassword());
		try {
			/*Authentication authentication = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

			SecurityContextHolder.getContext().setAuthentication(authentication);*/
			
			cs.loginC(login);
			String jwt = jwtUtils.generateJwtToken(loginRequest);
			
			//UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

			resp.setToken(jwt);
			resp.setEstatus("OK");
			resp.setMensaje("Login Exitoso");
		} catch (Exception e) {
			e.printStackTrace();
			resp.setMensaje("Bad login");
			resp.setDescripcionError("Error en las credeciales");
			resp.setEstatus("ERROR");
			return new ResponseEntity<Respuesta>(resp,HttpStatus.OK);
		}
		return new ResponseEntity<Respuesta>(resp,HttpStatus.OK);
	}

}
