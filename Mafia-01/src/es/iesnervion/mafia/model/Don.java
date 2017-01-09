package es.iesnervion.mafia.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "Dons")
public class Don implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5419420359250503075L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "Nombre")
	private String nombre;
	
	@Column(name = "Apellidos")
	private String apellido;
	
	@Column(name = "Apodo")
	private String apodo;
	
	@Column(name = "Procedencia")
	private String Procedencia;
	
	//TODO Crear un attr con la clase familia
	
	public Don() {
		
	}
	
	

	public Don(String nombre, String apellido, String apodo, String procedencia) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.apodo = apodo;
		Procedencia = procedencia;
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getApodo() {
		return apodo;
	}

	public void setApodo(String apodo) {
		this.apodo = apodo;
	}

	public String getProcedencia() {
		return Procedencia;
	}

	public void setProcedencia(String procedencia) {
		Procedencia = procedencia;
	}



	@Override
	public String toString() {
		return "Don [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", apodo=" + apodo + ", Procedencia="
				+ Procedencia + "]";
	}
	
	

}
