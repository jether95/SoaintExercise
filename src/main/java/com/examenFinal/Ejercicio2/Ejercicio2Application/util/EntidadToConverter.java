package com.examenFinal.Ejercicio2.Ejercicio2Application.util; 

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.examenFinal.Ejercicio2.Ejercicio2Application.dto.EstudianteResponse;
import com.examenFinal.Ejercicio2.Ejercicio2Application.entities.Estudiante;

@Component
public class EntidadToConverter {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public EstudianteResponse convertirEntidad(Estudiante estudiante) {
		return modelMapper.map(estudiante, EstudianteResponse.class);
	}
	
	public List<EstudianteResponse> convertirEntidad(List<Estudiante> estudiantes) {
		return estudiantes.stream()
				.map(estudiante -> convertirEntidad(estudiante))
				.collect(Collectors.toList());
	}

}
