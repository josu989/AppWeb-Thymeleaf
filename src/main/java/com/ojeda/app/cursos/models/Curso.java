package com.ojeda.app.cursos.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="cursos")
public class Curso {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, 
	generator = "CUST_SEQ5")
	@SequenceGenerator(sequenceName = "customer_seq5", 
	allocationSize = 1, name = "CUST_SEQ5")
	private Long id;
	
	@NotEmpty(message="Nombre de curso requerdio")
	private String nombre;
	
	@NotEmpty(message="Descripcion requerida")
	private String descripcion;
	
	@NotNull(message="Duracion requerdida")
	@Column (name="horas_duracion")
	private Double horasDuracion;
	
	@ManyToOne
	@JoinColumn(name="instructor_id")
	private Instructor instructor;
	
	@OneToOne
	@JoinColumn(name="temario_id")
	private Temario temario;
	
	@ManyToOne
	@JoinColumn(name="categoria_id")
	private Categoria categoria;

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

	public Double getHorasDuracion() {
		return horasDuracion;
	}

	public void setHorasDuracion(Double horasDuracion) {
		this.horasDuracion = horasDuracion;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Temario getTemario() {
		return temario;
	}

	public void setTemario(Temario temario) {
		this.temario = temario;
	}

	public Curso() {
		super();
	}
	
	

}
