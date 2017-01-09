package es.iesnervion.mafia.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity(name = "Famiglias")
public class Famiglias implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4408058007766741344L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "Nombre")
	private String nombre;
	
	@Column(name = "CiudadPrincipal")
	private String ciudadPrincipal;
	
	@Column(name = "Miembros")
	private short miembros;
	
	@OneToOne(cascade=CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Don don;
	
	
	public Famiglias() {
	}
	
	

	public Famiglias(String nombre, String ciudadPrincipal, short miembros, Don don) {
		super();
		this.nombre = nombre;
		this.ciudadPrincipal = ciudadPrincipal;
		this.miembros = miembros;
		this.don = don;
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


	public String getCiudadPrincipal() {
		return ciudadPrincipal;
	}


	public void setCiudadPrincipal(String ciudadPrincipal) {
		this.ciudadPrincipal = ciudadPrincipal;
	}


	public short getMiembros() {
		return miembros;
	}


	public void setMiembros(short miembros) {
		this.miembros = miembros;
	}


	public Don getDon() {
		return don;
	}


	public void setDon(Don don) {
		this.don = don;
	}



	@Override
	public String toString() {
		return "Familia [id=" + id + ", nombre=" + nombre + ", ciudadPrincipal=" + ciudadPrincipal + ", miembros="
				+ miembros + ", don=" + don + "]";
	}
	
	
	
}
