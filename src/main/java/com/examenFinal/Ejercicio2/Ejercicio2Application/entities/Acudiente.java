package com.examenFinal.Ejercicio2.Ejercicio2Application.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity

@Table(name="Acudiente")
public class Acudiente {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column( name = "Nombre")
	private String nombre;
	
	@Column( name = "Parentesco")
	private String parentesco;
	
	@Column( name = "telefono")
	private String telefono;
	
	@ManyToOne( cascade = CascadeType.ALL )
	private Estudiante estudiante;

}
