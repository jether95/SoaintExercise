package com.examenFinal.Ejercicio2.Ejercicio2Application.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@ApiModel( description = "informacion del acudiente")
public class AcudienteRequest {

	@ApiModelProperty(  notes = "nombre del acudiente", example = "Ximena", required = true)
	private String nombre;
	
	@ApiModelProperty(  notes = "Parentesco con el estudiante", example = "Madre", required = true)
	private String parentesco;
	
	@ApiModelProperty(  notes = "Telefono personal", example = "3114344343", required = true)
	private String telefono;
}
