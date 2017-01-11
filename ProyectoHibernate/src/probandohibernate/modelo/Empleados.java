
package probandohibernate.modelo;

/**
 *
 * @author leo
 */
 
import java.sql.Date;
import javax.persistence.*;
/**
 *
 * @author John
 */
@Entity
@Table(name = "Empleados")
public class Empleados {
 
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY) //Editado
    private Long id;
    @Column(name = "Nombre")
    private String nombre;
    @Column(name = "Apellidos")
    private String apellido;
    @Column(name = "FechaNacimiento")
    private Date fechaNacimiento;
    @Column(name = "Movil")
    private String movil;
 
    public Empleados() {
    }
 
    public Empleados(String nombre, String apellido, Date fechaNacimiento, String movil) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.movil = movil;
 
    }
 
    public Long getId() {
        return id;
    }
 
    public String getNombre() {
        return nombre;
    }
 
    public String getApellido() {
        return apellido;
    }
 
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }
 
    public String getMovil() {
        return movil;
    }
 
    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setMovil(String movil) {
        this.movil = movil;
    }

	@Override
	public String toString() {
		return "Empleado [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", fechaNacimiento="
				+ fechaNacimiento + ", movil=" + movil + "]";
	}
    
    
 
}