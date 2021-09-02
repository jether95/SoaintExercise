package com.examenFinal.Ejercicio2.Ejercicio2Application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examenFinal.Ejercicio2.Ejercicio2Application.entities.Estudiante;

public interface EstudianteRepository extends JpaRepository<Estudiante, Long>{ 
	public Estudiante findById (String numeroId);
	public List<Estudiante> findByEdadAndEstado(int edad, boolean estado);

}
