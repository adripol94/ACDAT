package es.iesnervion.model;

import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name="BI_Mascotas_Enfermedades")
public class EnfermedadMascota{
	
	@Id
	@ManyToOne
	@JoinColumn(name="IDEnfermedad")
	private Enfermedad enfermedad;
	
	@Id
	@ManyToOne
	@JoinColumn(name="Mascota")
	private Mascota mascota;
	
	@Column(name="FechaInicio")
	private Date fechaInicio;
	
	@Column(name="FechaCura")
	private Date fechaCura;
	
	public EnfermedadMascota(){}
	
	public EnfermedadMascota(Enfermedad enfermedad, Mascota mascota, Date fechaInicio, Date fechaCura) {
		super();
		this.enfermedad = enfermedad;
		this.mascota = mascota;
		this.fechaInicio = fechaInicio;
		this.fechaCura = fechaCura;
	}

	public Enfermedad getEnfermedad() {
		return enfermedad;
	}

	public void setEnfermedad(Enfermedad enfermedad) {
		this.enfermedad = enfermedad;
	}

	public Mascota getMascota() {
		return mascota;
	}

	public void setMascota(Mascota mascota) {
		this.mascota = mascota;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaCura() {
		return fechaCura;
	}

	public void setFechaCura(Date fechaCura) {
		this.fechaCura = fechaCura;
	}
	
	
}
