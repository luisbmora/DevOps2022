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

import com.mora.modelos.Categorias;
import com.mora.modelos.Respuesta;
import com.mora.service.CategoriasService;

import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RequestMapping ("/categorias")
@RestController
public class CategoriasRest {
	Logger log = LoggerFactory.getLogger(CategoriasRest.class);
	@Autowired
	CategoriasService ps;

	@PostMapping
	@ApiOperation(value="Web service para insertar una nueva Categoria", response=Categorias[].class)
	public ResponseEntity<Respuesta> crearCliente(@RequestBody Categorias categorias) {
		Respuesta resp = new Respuesta();
		//log.info(plan.getDescripcion()+ " jhdkjshdfkljshd");
		try {
			 ps.insertar(categorias);
		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
			resp.setDescripcionError(e.getMessage());
			resp.setEstatus("ERROR");
			resp.setMensaje("Ocurrió un problema al crear la categoria");
			return new ResponseEntity<>(resp, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		resp.setEstatus("OK");
		resp.setMensaje("Categoria creada exitosamente");
		return new ResponseEntity<>(resp, HttpStatus.CREATED);
	}
	
	
	@GetMapping("/{id}")
	@ApiOperation(value="Web service para obtener un listado de Categorias", response=Categorias[].class)//le damos descripcion al swagger
	public ResponseEntity<Respuesta> consultar(@RequestParam int id){
		Categorias categorias = new Categorias();
		Respuesta res = new Respuesta();//invocamos el modelo de respuesta para personalizar las respuetas
		try {
		categorias = ps.buscar(id);
			
		} catch (Exception e) {//cachamos el error si es de base de datos
			e.printStackTrace();
			log.error(e.getMessage());
			res.setDescripcionError(e.getMessage());
			res.setEstatus("ERROR");
			res.setMensaje("Falló la obtención del listado de perfiles");
			res.setObject(categorias);
			return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
		} //de lo contrario todo esta bien y se mandara el objeto
		res.setEstatus("OK");
		res.setMensaje("OK");
		res.setObject(categorias);
		return new ResponseEntity<>(res, HttpStatus.OK);
		
	}
	
	/*@PostMapping
	public ResponseEntity<Respuesta> crearCliente(@RequestBody Actores actores) {
		Respuesta resp = new Respuesta();
		//log.info(plan.getDescripcion()+ " jhdkjshdfkljshd");
		try {
			 ps.insertar(actores);
		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
			resp.setDescripcionError(e.getMessage());
			resp.setEstatus("ERROR");
			resp.setMensaje("Ocurrió un problema al crear un nuevo Actor");
			return new ResponseEntity<>(resp, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		resp.setEstatus("OK");
		resp.setMensaje("Actor creado exitosamente");
		return new ResponseEntity<>(resp, HttpStatus.CREATED);
	}*/
	
	@PutMapping("/{id}")
	public ResponseEntity<Respuesta> modificarCategorias(@PathVariable int id,@RequestBody Categorias categorias) {
		Respuesta resp = new Respuesta();
		//log.info(plan.getDescripcion()+ " jhdkjshdfkljshd");
		try {
			 ps.modificar(id,categorias);
		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
			resp.setDescripcionError(e.getMessage());
			resp.setEstatus("ERROR");
			resp.setMensaje("Ocurrió un problema al modificar la categoria");
			return new ResponseEntity<>(resp, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		resp.setEstatus("OK");
		resp.setMensaje("Categoria modificada exitosamente");
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
			resp.setMensaje("Ocurrió un problema al desactivar la categoria");
			return new ResponseEntity<>(resp, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		resp.setEstatus("OK");
		resp.setMensaje("Categoria desactivada exitosamente");
		return new ResponseEntity<>(resp, HttpStatus.CREATED);
	}
}
