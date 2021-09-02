package com.examenFinal.Ejercicio2.Ejercicio2Application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.examenFinal.Ejercicio2.Ejercicio2Application.dto.EstudianteRequest;
import com.examenFinal.Ejercicio2.Ejercicio2Application.dto.EstudianteResponse;
import com.examenFinal.Ejercicio2.Ejercicio2Application.entities.Estudiante;
import com.examenFinal.Ejercicio2.Ejercicio2Application.service.EstudianteService;
import com.examenFinal.Ejercicio2.Ejercicio2Application.util.EntidadToConverter;

import io.swagger.annotations.ApiOperation;
import io.swagger.models.Path;

@RestController
public class EstudianteController {
	
	@Autowired
	private EstudianteService estService;

	@Autowired
	private EntidadToConverter convertidor;
	
	
	@GetMapping( value = "estudiante" )
	@ApiOperation ( value = "listar estudiantes", notes = "lista los estudiantes")
	public ResponseEntity<List<EstudianteResponse>> listarEstudiante(){
		List<Estudiante> listaEstudiantes = estService.listarEstudiante();
		return new ResponseEntity<>(convertidor.convertirEntidad(listaEstudiantes), HttpStatus.OK);
		
	}
	
	@GetMapping( value = "estudiante/estudiantePorEdad/{edad}/{estado}")
	public ResponseEntity<List<EstudianteResponse>> listarEstudiantePorEdad(@PathVariable int edad,@PathVariable boolean estado){
		List<Estudiante> listaPorEdad = estService.estudiantePorEdad(edad, estado);
		return new ResponseEntity<>(convertidor.convertirEntidad(listaPorEdad), HttpStatus.OK);
	}
	
	
	@PostMapping(value = "estudiante")
	public ResponseEntity<EstudianteResponse> crearEstudiante(@RequestBody EstudianteRequest payload) {
		Estudiante estudiante = estService.crearEstudiante(payload);
		return new ResponseEntity<>(convertidor.convertirEntidad(estudiante), HttpStatus.CREATED);
	}
	
	@GetMapping(value = "estudiante/buscar/{id}")
	public ResponseEntity<Estudiante> buscarEstudiante(@PathVariable Long id){
		Estudiante estudiante = estService.searchEst(id);
		return new ResponseEntity<>(estudiante, HttpStatus.OK);
	}
	
	@PutMapping(value = "estudiante/actualizar/{id}")
	public ResponseEntity<Estudiante> actualizarEstudiante(@PathVariable Long id, @RequestBody EstudianteRequest payload){
		Estudiante estudiante = estService.actualizarEstudiante(id, payload);
		return new ResponseEntity<>(estudiante, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "estudiante/eliminar/{id}")
	public ResponseEntity<Estudiante> eliminarEstudiante(@PathVariable Long id, @RequestBody EstudianteRequest payload){
		Estudiante estudiante = estService.eliminarEstudiante(id, payload);
		return new ResponseEntity<>(estudiante, HttpStatus.OK);
	}
	
	
	
}
