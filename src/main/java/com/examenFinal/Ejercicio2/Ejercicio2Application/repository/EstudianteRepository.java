package com.examenFinal.Ejercicio2.Ejercicio2Application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examenFinal.Ejercicio2.Ejercicio2Application.entities.Estudiante;

public interface EstudianteRepository extends JpaRepository<Estudiante, Long>{ 
	public Estudiante findById (String numeroId);

}
