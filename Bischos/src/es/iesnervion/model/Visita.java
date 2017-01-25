package es.iesnervion.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name="BI_Visitas")
public class Visita implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="Fecha")
	private Date fecha;
	
	@Column(name="Temperatura")
	private byte temperatura;
	
	@Column(name="Peso")	
	private int peso;
	
	@ManyToOne
	@JoinColumn(name="Mascota")
	private Mascota mascota;
	
	public Visita(){}
	
	public Visita(int id, Date fecha, int peso, Mascota mascota) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.peso = peso;
		this.mascota = mascota;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public Mascota getMascota() {
		return mascota;
	}

	public void setMascota(Mascota mascota) {
		this.mascota = mascota;
	}

	public byte getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(byte temperatura) {
		this.temperatura = temperatura;
	}

	@Override
	public String toString() {
		return "Visita [id=" + id + ", fecha=" + fecha + ", temperatura=" + temperatura + ", peso=" + peso
				+ ", mascota=" + mascota + "]";
	}
	
	
}
