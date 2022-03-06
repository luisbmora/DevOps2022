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

import com.mora.modelos.Perfil;
import com.mora.modelos.Plan;
import com.mora.modelos.Respuesta;
import com.mora.service.PerfilesService;

import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;


@RequestMapping ("/Perfil")
@RestController
public class PerfilesRest {
	Logger log = LoggerFactory.getLogger(PerfilesRest.class);
	@Autowired
	PerfilesService ps;
	
	@GetMapping("/{id}")
	@ApiOperation(value="Web service para obtener un listado de perfiles", response=Perfil[].class)//le damos descripcion al swagger
	public ResponseEntity<Respuesta> consultar(@RequestParam int id){
		Perfil perfil = new Perfil();
		Respuesta res = new Respuesta();//invocamos el modelo de respuesta para personalizar las respuetas
		try {
			perfil = ps.buscar(id);
			
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
	
	/*@PostMapping
	public ResponseEntity<Respuesta> crearCliente(@RequestBody Perfil perfil) {
		Respuesta resp = new Respuesta();
		//log.info(plan.getDescripcion()+ " jhdkjshdfkljshd");
		try {
			 ps.insertar(perfil);
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
	}*/
	
	@PutMapping("/{id}")
	public ResponseEntity<Respuesta> modificarPerfil(@PathVariable int id,@RequestBody Perfil perfil) {
		Respuesta resp = new Respuesta();
		//log.info(plan.getDescripcion()+ " jhdkjshdfkljshd");
		try {
			 ps.modificar(id,perfil);
		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
			resp.setDescripcionError(e.getMessage());
			resp.setEstatus("ERROR");
			resp.setMensaje("Ocurrió un problema al modificar el perfil");
			return new ResponseEntity<>(resp, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		resp.setEstatus("OK");
		resp.setMensaje("Perfil modificado exitosamente");
		return new ResponseEntity<>(resp, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}/{activo}")
	public ResponseEntity<Respuesta> calcelarCuenta(@PathVariable int id,@PathVariable int activo) {
		Respuesta resp = new Respuesta();
		log.info(activo+ " jhdkjshdfkljshd");
		try {
			 ps.desactivar(id,activo);
		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
			resp.setDescripcionError(e.getMessage());
			resp.setEstatus("ERROR");
			resp.setMensaje("Ocurrió un problema al desactivar el perfil");
			return new ResponseEntity<>(resp, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		resp.setEstatus("OK");
		resp.setMensaje("Perfil desactivado exitosamente");
		return new ResponseEntity<>(resp, HttpStatus.CREATED);
	}
}
