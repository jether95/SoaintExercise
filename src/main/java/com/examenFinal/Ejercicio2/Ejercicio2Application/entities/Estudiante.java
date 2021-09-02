package com.examenFinal.Ejercicio2.Ejercicio2Application.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

@Table(name = "tblEstudiante")
public class Estudiante {
	
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nombre", length = 60)
	private String nombre;
	
	@Column(name = "numero_identificacion")
	private String numeroIdentificacion;
	
	@Column(name = "correo")
	private String correo;
	
	@Column(name = "edad")
	private int edad;
	
	@Column(name = "Estado_Estudiante")
	private boolean estadoActivo;
	

	@OneToMany( fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "estudiante")
	private List<Acudiente> acudiente;
}
