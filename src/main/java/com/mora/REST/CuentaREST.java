package com.mora.REST;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mora.modelos.Cuentas;
import com.mora.modelos.Perfil;
import com.mora.modelos.Plan;
import com.mora.modelos.Respuesta;
import com.mora.service.CuentaService;
import com.mora.service.PerfilesService;
import com.mora.service.PlanService;

import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;


@RequestMapping("/cuentas")
@RestController
public class CuentaREST {
	
Logger log = LoggerFactory.getLogger(CuentaREST.class);
	
	@Autowired
	CuentaService cs;
	
	@Autowired
	PerfilesService ps;
	
	@GetMapping
	@ApiOperation(value="Web service para obtener un listado de cuentas", response=CuentaREST[].class)
	public ResponseEntity<Respuesta> consultar(){
		List<Cuentas> cuentas = new ArrayList<>();
		Respuesta res = new Respuesta();
		try {
			cuentas = cs.consultar();
			if (cuentas.isEmpty()) {
				res.setDescripcionError("Listado de cuentas vacío");
				res.setEstatus("ERROR");
				res.setMensaje("No se encontraron las cuentas registrados en la base de datos");
				res.setObject(cuentas);
				return new ResponseEntity<>(res, HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
			res.setDescripcionError(e.getMessage());
			res.setEstatus("ERROR");
			res.setMensaje("Falló la obtención del listado de cuentas");
			res.setObject(cuentas);
			return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
		} 
		res.setEstatus("OK");
		res.setMensaje("OK");
		res.setObject(cuentas);
		return new ResponseEntity<>(res, HttpStatus.OK);
		
	}
	
	/*@PostMapping
	@ApiOperation(value="Web service para obtener un listado de cuentas", response=CuentaREST[].class)
	public ResponseEntity<Respuesta> crearCliente(@RequestBody Cuentas cuentas) {
		Respuesta resp = new Respuesta();
		//log.info(plan.getDescripcion()+ " jhdkjshdfkljshd");
		try {
			 cs.insertar(cuentas);
		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
			resp.setDescripcionError(e.getMessage());
			resp.setEstatus("ERROR");
			resp.setMensaje("Ocurrió un problema al crear una nueva cuenta");
			return new ResponseEntity<>(resp, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		resp.setEstatus("OK");
		resp.setMensaje("Cuenta creada exitosamente");
		return new ResponseEntity<>(resp, HttpStatus.CREATED);
	}*/
	 
	@PutMapping("/{id}")
	public ResponseEntity<Respuesta> modificar(@PathVariable int id, @RequestBody Cuentas cuentas) {
		Respuesta resp = new Respuesta();
		//log.info(plan.getDescripcion()+ " jhdkjshdfkljshd");
		try {
			 cs.modificar(id,cuentas);
		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
			resp.setDescripcionError(e.getMessage());
			resp.setEstatus("ERROR");
			resp.setMensaje("Ocurrió un problema al modificar la cuenta");
			return new ResponseEntity<>(resp, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		resp.setEstatus("OK");
		resp.setMensaje("Cuenta modificada exitosamente");
		return new ResponseEntity<>(resp, HttpStatus.CREATED);
	}
	
	/*@PutMapping("/{id}/plan/{idPlan}")
	public ResponseEntity<Respuesta> modificarPlan(@PathVariable int id,@PathVariable int idPlan) {
		Respuesta resp = new Respuesta();
		//log.info(plan.getDescripcion()+ " jhdkjshdfkljshd");
		try {
			 cs.modificarPlan(id,idPlan);
		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
			resp.setDescripcionError(e.getMessage());
			resp.setEstatus("ERROR");
			resp.setMensaje("Ocurrió un problema al modificar el plan");
			return new ResponseEntity<>(resp, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		resp.setEstatus("OK");
		resp.setMensaje("Plan modificado exitosamente");
		return new ResponseEntity<>(resp, HttpStatus.CREATED);
	}*/
	
	@DeleteMapping("/{id}/{activa}")
	public ResponseEntity<Respuesta> calcelarCuenta(@PathVariable int id,@PathVariable int activa) {
		Respuesta resp = new Respuesta();
		log.info(activa+ " jhdkjshdfkljshd");
		try {
			 cs.desactivar(id,activa);
		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
			resp.setDescripcionError(e.getMessage());
			resp.setEstatus("ERROR");
			resp.setMensaje("Ocurrió un problema al desactivar la cuenta");
			return new ResponseEntity<>(resp, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		resp.setEstatus("OK");
		resp.setMensaje("Cuenta desactivada exitosamente");
		return new ResponseEntity<>(resp, HttpStatus.CREATED);
	}
	
	@PostMapping("/{idCuenta}/perfil")
	@ApiOperation(value="Web service para crear perfil por cuenta", response=CuentaREST[].class)
	public ResponseEntity<Respuesta> crearCliente(@PathVariable int idCuenta, @RequestBody Perfil perfil) {
		Respuesta resp = new Respuesta();
		//log.info(plan.getDescripcion()+ " jhdkjshdfkljshd");
		try {
			 ps.insertar(perfil, idCuenta);
		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
			resp.setDescripcionError(e.getMessage());
			resp.setEstatus("ERROR");
			resp.setMensaje("Ocurrió un problema al crear un nuevo Perfil");
			return new ResponseEntity<>(resp, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		resp.setEstatus("OK");
		resp.setMensaje("Perfil creado exitosamente");
		return new ResponseEntity<>(resp, HttpStatus.CREATED);
	}
	
	@GetMapping("/{idCuenta}/perfiles")
	@ApiOperation(value="Web service para obtener un listado de perfiles por idCuenta", response=Perfil[].class)//le damos descripcion al swagger
	public ResponseEntity<Respuesta> consultar(@RequestParam int idCuenta){
		List<Perfil> perfil = new ArrayList<>();
		Respuesta res = new Respuesta();//invocamos el modelo de respuesta para personalizar las respuetas
		try {
			perfil = ps.buscarPorCuenta(idCuenta);
			if (perfil.isEmpty()) {//comparamos si la lista esta vacia
				res.setDescripcionError("Listado de planes vacío");
				res.setEstatus("ERROR");
				res.setMensaje("No se encontraron los perfiles registrados en la base de datos");
				res.setObject(perfil);
				return new ResponseEntity<>(res, HttpStatus.NO_CONTENT);
			}
			
		} catch (Exception e) {//cachamos el error si es de base de datos
			e.printStackTrace();
			log.error(e.getMessage());
			res.setDescripcionError(e.getMessage());
			res.setEstatus("ERROR");
			res.setMensaje("Falló la obtención del listado de perfiles");
			res.setObject(perfil);
			return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
		} //de lo contrario todo esta bien y se mandara el objeto
		res.setEstatus("OK");
		res.setMensaje("OK");
		res.setObject(perfil);
		return new ResponseEntity<>(res, HttpStatus.OK);
		
	}
}
