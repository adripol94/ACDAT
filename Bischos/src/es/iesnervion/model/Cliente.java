package es.iesnervion.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="dbo.BI_Clientes")
public class Cliente {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="Telefono")
	private String tlf;
	
	@Column(name="Direccion")
	private String direccion;
	
	@Column(name="NumeroCuenta")
	private String numCuenta;
	
	@Column(name="Nombre")
	private String nombre;
	
	@OneToMany(mappedBy="CodigoPropietario", cascade=CascadeType.ALL)
	private Set<Mascota> mascotas = new HashSet();
	
	public Cliente(){}
	
	public Cliente(int id, String tlf, String direccion, String numCuenta, String nombre, Set<Mascota> mascotas) {
		super();
		this.id = id;
		this.tlf = tlf;
		this.direccion = direccion;
		this.numCuenta = numCuenta;
		this.nombre = nombre;
		this.mascotas = mascotas;
	}
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTlf() {
		return tlf;
	}

	public void setTlf(String tlf) {
		this.tlf = tlf;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNumCuenta() {
		return numCuenta;
	}

	public void setNumCuenta(String numCuenta) {
		this.numCuenta = numCuenta;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Mascota> getMascotas() {
		return mascotas;
	}

	public void setMascotas(Set<Mascota> mascotas) {
		this.mascotas = mascotas;
	}
	
	
}
