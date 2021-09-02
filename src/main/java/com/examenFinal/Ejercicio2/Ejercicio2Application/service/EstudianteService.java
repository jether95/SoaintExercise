package com.examenFinal.Ejercicio2.Ejercicio2Application.service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.examenFinal.Ejercicio2.Ejercicio2Application.dto.EstudianteRequest;
import com.examenFinal.Ejercicio2.Ejercicio2Application.entities.Acudiente;
import com.examenFinal.Ejercicio2.Ejercicio2Application.entities.Estudiante;
import com.examenFinal.Ejercicio2.Ejercicio2Application.repository.EstudianteRepository;

@Service
public class EstudianteService {
	@Autowired
	private EstudianteRepository estRespository;
	
	public Estudiante crearEstudiante(EstudianteRequest payload) {

		Estudiante estudiante = new Estudiante();
		
		estudiante.setNombre( payload.getNombre() );
		estudiante.setNumeroIdentificacion( payload.getNumero() );
		estudiante.setCorreo(payload.getCorreo());
		estudiante.setEdad(payload.getEdad());
		
		List<Acudiente> acudientes = payload.getAcudiente().stream()
				.map(acudiente-> Acudiente.builder()
						.nombre(acudiente.getNombre())
						.parentesco(acudiente.getParentesco())
						.telefono(acudiente.getTelefono())
						.estudiante(estudiante).build()
						).collect(Collectors.toList());
		
		estudiante.setAcudiente(acudientes);
		
		estRespository.save(estudiante);
		return estudiante;
	}
	
	public List<Estudiante> listarEstudiante(){
		List<Estudiante> listaEstudiante = estRespository.findAll();
		return listaEstudiante;
	}
	
	public Estudiante searchEst(Long id) {
		Estudiante estudiante = new Estudiante();
		estudiante = estRespository.findById(id).get();
		return estudiante;
	}
	
	
	public Estudiante actualizarEstudiante(Long id, EstudianteRequest payload) {
		Estudiante estudiante = searchEst(id);
		
		
		estudiante.setNombre(payload.getNombre());
		estudiante.setNumeroIdentificacion(payload.getNumero());
		estudiante.setCorreo(payload.getCorreo());
		estudiante.setEdad(payload.getEdad());
		
		
		estRespository.save(estudiante);
		
		return estudiante;
	}
}
