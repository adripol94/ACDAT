
package probandohibernate;

/**
 *
 * @author leo
 */

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import probandohibernate.modelo.Empleados;
public class ProbandoHibernate {

   private static SessionFactory sessionFactory = null;
 
    public static void main(String[] args) {
    	insert();
      read();
    }
    
    private static void read(){
    	  Session session = null;
          try {
              try {
              	
              	sessionFactory = PersonFactory.getSessionFactory();
              	session = sessionFactory.openSession();
              	
              	@SuppressWarnings("unchecked")
  				List<Empleados> list = session.createQuery("from Empleados")
              			.list();
              	
              	for (Empleados p : list)
              		System.out.println(p);
              	
              	
              } catch (Exception e) {
                  e.printStackTrace();
              }
          } finally {
              session.close();
          }
    }
    
    private static void insert() {
    	  Session session = null;
          try {
              try {
                  sessionFactory = PersonFactory.getSessionFactory();
                  session = sessionFactory.openSession();
   
                  System.out.println("Insertando registro");
                  Transaction tx = session.beginTransaction();
                  //Creando un Objeto
//                  Empleado employe = new Empleado();
//                  employe.setNombre("Juanito");
//                  employe.setApellido("De la Vega");
                  Empleados fulanito = new Empleados();
                  fulanito.setApellido("Martuki");
                  fulanito.setNombre("Merina");
                  fulanito.setMovil("666111020");
                  Date now = new Date(06170);
                  fulanito.setFechaNacimiento(now);
                  //Guardando
                  //session.save(employe);
                  session.save(fulanito);
                  fulanito.setApellido("Liflor");
                  tx.commit();
                  System.out.println("Finalizado...");
              	
              	
              } catch (Exception e) {
                  e.printStackTrace();
              }
          } finally {
              session.close();
          }
    }
    
}
