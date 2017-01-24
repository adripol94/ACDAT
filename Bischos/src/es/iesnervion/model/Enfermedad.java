package es.iesnervion.model;

import java.util.Set;

import javax.persistence.*;


@Entity
@Table(name="dbo.BI_Enfermedades")
public class Enfermedad {
	
	private int id;
	
	@Column(name="Nombre")
	private String nombre;
	
	private Set<EnfermedadMascota> enfermedadesMascotas;
	
	public Enfermedad(){}
	
	public Enfermedad(int id, String nombre, Set<EnfermedadMascota> enfermedadesMascotas) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.enfermedadesMascotas = enfermedadesMascotas;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<EnfermedadMascota> getEnfermedadesMascotas() {
		return enfermedadesMascotas;
	}

	public void setEnfermedadesMascotas(Set<EnfermedadMascota> enfermedadesMascotas) {
		this.enfermedadesMascotas = enfermedadesMascotas;
	}
	
	
	
}
