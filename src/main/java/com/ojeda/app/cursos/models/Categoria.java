package com.ojeda.app.cursos.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;


@Entity
@Table(name= "categorias")
public class Categoria {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, 
	generator = "CUST_SEQ")
	@SequenceGenerator(sequenceName = "customer_seq", 
	allocationSize = 1, name = "CUST_SEQ")
	private Long id;
	
	@Column
	@NotEmpty(message="El nombre de la categoria es requerida")
	@Size(max=45, message="El nombre no debe exceder los 45 caracteres")
	private String nombre;
		
	@Column(name = "numero_cursos")
	private Integer numeroCursos;
	
	
	
	
	

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getNumeroCursos() {
		return numeroCursos;
	}
	public void setNumeroCursos(Integer numeroCursos) {
		this.numeroCursos = numeroCursos;
	}
	public Categoria() {
		super();
	}
	public Categoria(Long id, String nombre, Integer numeroCursos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.numeroCursos = numeroCursos;
	}
	
}