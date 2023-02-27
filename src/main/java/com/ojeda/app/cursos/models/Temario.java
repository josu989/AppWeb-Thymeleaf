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
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="temarios")
public class Temario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, 
	generator = "CUST_SEQ4")
	@SequenceGenerator(sequenceName = "customer_seq4", 
	allocationSize = 1, name = "CUST_SEQ4")
	private Long id;

	@NotEmpty(message="nombre requerido")
	private String nombre;
	
	@NotEmpty(message="descripcion requerida")
	private String descripcion;
	
	@NotNull(message="numero de actividades requerido")
	private Integer numActividades;
	
	private Integer numTemas;

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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getNumActividades() {
		return numActividades;
	}

	public void setNumActividades(Integer numActividades) {
		this.numActividades = numActividades;
	}

	public Integer getNumTemas() {
		return numTemas;
	}

	public void setNumTemas(Integer numTemas) {
		this.numTemas = numTemas;
	}

	public Temario() {
		super();
	}
	
	
}