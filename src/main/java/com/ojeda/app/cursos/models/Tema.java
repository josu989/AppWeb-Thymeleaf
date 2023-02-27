package com.ojeda.app.cursos.models;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="temas")
public class Tema {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, 
	generator = "CUST_SEQ3")
	@SequenceGenerator(sequenceName = "customer_seq3", 
	allocationSize = 1, name = "CUST_SEQ3")
	
	private Long id;
	
	@NotEmpty(message="Nombre requerido")
	@Column(unique = true) //columna unica 
	private String nombre;
	
	@NotNull(message="Duracion es requerido")
	private Double duracion;
	
	@ManyToOne(fetch  = FetchType.LAZY, optional = false) //muchos Tema tiene un Temario
	@JoinColumn(name="temario_id")
	private Temario temario;

	public Tema() {
		super();
	}

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

	public Double getDuracion() {
		return duracion;
	}

	public void setDuracion(Double duracion) {
		this.duracion = duracion;
	}

	public Temario getTemario() {
		return temario;
	}

	public void setTemario(Temario temario) {
		this.temario = temario;
	}
	
	
	
}
