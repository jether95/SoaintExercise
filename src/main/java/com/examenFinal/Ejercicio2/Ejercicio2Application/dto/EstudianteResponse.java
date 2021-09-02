package com.examenFinal.Ejercicio2.Ejercicio2Application.dto;

import lombok.Data;

@Data
public class EstudianteResponse {
	private Long id;
	private String nombre;
	private String numeroIdentificacion;
	private String correo;
	private int edad;
	private boolean estado;
}
