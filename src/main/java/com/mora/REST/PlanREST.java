package com.mora.REST;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mora.modelos.Cuentas;
import com.mora.modelos.Plan;
import com.mora.modelos.Respuesta;
import com.mora.service.CuentaService;
import com.mora.service.PlanService;

import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

import java.util.ArrayList;
import java.util.List;


//import io.swagger.annotations.ApiOperation;

@RequestMapping("/planes")// nombramos la rutas
@RestController
public class PlanREST {
	Logger log = LoggerFactory.getLogger(PlanREST.class);//para pintar en consola
	
	@Autowired
	PlanService ps;
	
	@Autowired
	CuentaService cs;
	
	
	@GetMapping
	@ApiOperation(value="Web service para obtener un listado de planes", response=Plan[].class)//le damos descripcion al swagger
	public ResponseEntity<Respuesta> consultar(){
		List<Plan> planes = new ArrayList<>();
		Respuesta res = new Respuesta();//invocamos el modelo de respuestA para personalizar las respuetas
		try {
			planes = ps.consultar();
			if (planes.isEmpty()) {//comparamos si la lista esta vacia
				res.setDescripcionError("Listado de planes vacío");
				res.setEstatus("ERROR");
				res.setMensaje("No se encontraron los planes registrados en la base de datos");
				res.setObject(planes);
				return new ResponseEntity<>(res, HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {//cachamos el error si es de base de datos
			e.printStackTrace();
			log.error(e.getMessage());
			res.setDescripcionError(e.getMessage());
			res.setEstatus("ERROR");
			res.setMensaje("Falló la obtención del listado de planes");
			res.setObject(planes);
			return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
		} //de lo contrario todo esta bien y se mandara el onjeto
		res.setEstatus("OK");
		res.setMensaje("OK");
		res.setObject(planes);
		return new ResponseEntity<>(res, HttpStatus.OK);
		
	}
	
	@GetMapping("/{id}")// indicamos un parametro
	@ApiOperation(value="Web service para obtener un plan en  especifico", response=Plan[].class)
	public ResponseEntity<Respuesta> buscar(@PathVariable int id){// le indicamos que el parametro sera por el path
		Plan planes = new Plan();
		Respuesta res = new Respuesta();
		try {
			planes = ps.buscar(id);
		} catch(Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
			res.setDescripcionError(e.getMessage());
			res.setEstatus("ERROR");
			res.setMensaje("No se pudo encontrar el plan solicitado");
			return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
		}
		res.setMensaje("Plan encontrado");
		res.setEstatus("OK");
		res.setObject(planes);
		return new ResponseEntity<>(res, HttpStatus.OK);
		
	}
	
	@PostMapping
	@ApiOperation(value="Web service para crear plan", response=Plan[].class)
	public ResponseEntity<Respuesta> crearCliente(@RequestBody Plan plan) {
		Respuesta resp = new Respuesta();
		//log.info(plan.getDescripcion()+ " jhdkjshdfkljshd");
		try {
			 ps.insertar(plan);
		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
			resp.setDescripcionError(e.getMessage());
			resp.setEstatus("ERROR");
			resp.setMensaje("Ocurrió un problema al crear un nuevo Plan");
			return new ResponseEntity<>(resp, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		resp.setEstatus("OK");
		resp.setMensaje("Plan creado exitosamente");
		return new ResponseEntity<>(resp, HttpStatus.CREATED);
	}
	
	@PostMapping("/{idPlan}/cuenta")
	@ApiOperation(value="Web service para crear una cuenta por un plan", response=CuentaREST[].class)
	public ResponseEntity<Respuesta> crearCliente(@PathVariable int idPlan, @RequestBody Cuentas cuentas) {
		Respuesta resp = new Respuesta();
		log.info(idPlan+ " jhdkjshdfkljshd");
		try {
			 cs.insertar(cuentas, idPlan);
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
	}
	
	@PutMapping("/{idPlan}/cuenta/{idCuenta}")
	@ApiOperation(value="Web service para modificar el plan de la cuenta", response=CuentaREST[].class)
	public ResponseEntity<Respuesta> modificarPlan(@PathVariable int idPlan ,@PathVariable int idCuenta) {
		Respuesta resp = new Respuesta();
		//log.info(plan.getDescripcion()+ " jhdkjshdfkljshd");
		try {
			 cs.modificarPlan(idCuenta,idPlan);
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
	}

}
