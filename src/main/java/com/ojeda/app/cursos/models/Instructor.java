package com.ojeda.app.cursos.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name="instructores")
public class Instructor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, 
	generator = "CUST_SEQ2")
	@SequenceGenerator(sequenceName = "customer_seq2", 
	allocationSize = 1, name = "CUST_SEQ2")
	private Long id;
	//validaciones de no vacio
	@NotEmpty(message="nombre requerdio")
	@Column
	private String nombre;
	
	@NotEmpty(message="AP paterno es requerido")
	@Column(name="ap_paterno")
	private String apPaterno;
	
	@NotEmpty(message="AP materno es requerido")
	@Column(name="ap_materno")
	private String apMaterno;
	
	@Column
	@NotEmpty(message="correo requerido")
	@Email(message="Favor de ingresar un correo valido")
	private String email;
	
	@Column
	@NotEmpty(message="telefono es requerido")
	private String telefono;
	
	@Column(name="horas")
	private Double horas;
	
	@NotEmpty(message="El codgio es requerido")
	@Pattern(regexp="^[a-zA-Z]{3}-[0-9]{4}"   ,message="El codigo debe cumplir con el formato XXX-0000")
	@Column(name="codigo instructor")
	private String codigoInstructor;
	
	@Column(name="url_foto")
	private String urlFoto;

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

	public String getApPaterno() {
		return apPaterno;
	}

	public void setApPaterno(String apPaterno) {
		this.apPaterno = apPaterno;
	}

	public String getApMaterno() {
		return apMaterno;
	}

	public void setApMaterno(String apMaterno) {
		this.apMaterno = apMaterno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Double getHoras() {
		return horas;
	}

	public void setHoras(Double horas) {
		this.horas = horas;
	}

	public String getCodigoInstructor() {
		return codigoInstructor;
	}

	public void setCodigoInstructor(String codigoInstructor) {
		this.codigoInstructor = codigoInstructor;
	}

	public String getUrlFoto() {
		return urlFoto;
	}

	public void setUrlFoto(String urlFoto) {
		this.urlFoto = urlFoto;
	}

	public Instructor() {
		super();
	}

	/*public Instructor(Long id, @NotEmpty(message = "nombre requerdio") String nombre,
			@NotEmpty(message = "AP paterno es requerido") String apPaterno,
			@NotEmpty(message = "AP materno es requerido") String apMaterno,
			@NotEmpty(message = "correo requerido") @Email(message = "Favor de ingresar un correo valido") String email,
			@NotEmpty(message = "telefono es requerido") String telefono, Double horas,
			@NotEmpty(message = "El codgio es requerido") @Pattern(regexp = "El codigo debe cumplir con el formato XXX-000") String codigoInstructor,
			String urlFoto) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apPaterno = apPaterno;
		this.apMaterno = apMaterno;
		this.email = email;
		this.telefono = telefono;
		this.horas = horas;
		this.codigoInstructor = codigoInstructor;
		this.urlFoto = urlFoto;
	}*/
	
	
	

}
