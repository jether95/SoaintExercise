package com.examenFinal.Ejercicio2.Ejercicio2Application.dto;

import java.util.List;

import com.examenFinal.Ejercicio2.Ejercicio2Application.entities.Acudiente;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EstudianteRequest {
	@ApiModelProperty(  notes = "numero de identificacion estudiante", example = "1234")
	private String numero;
	
	@ApiModelProperty(  notes = "nombre estudiante", example = "juan")
	private String nombre;
	
	private int edad;
	
	@ApiModelProperty(  notes = "correo del estudiante", example = "pepito@gmail.com")
	private String correo;
	
	private List<AcudienteRequest> acudiente;
}
