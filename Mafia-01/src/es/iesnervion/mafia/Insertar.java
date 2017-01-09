package es.iesnervion.mafia;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import es.iesnervion.mafia.model.Don;
import es.iesnervion.mafia.model.Famiglias;

public class Insertar {
	
	private static SessionFactory sessionfactory = null;
	
	public static void insertFamiglia(Famiglias f) {
		Session sesion = null;
		Transaction tx;
		
		try {
			sessionfactory = Mafiafactory.getSessionFactory();
			sesion = sessionfactory.openSession();
			
			tx = sesion.beginTransaction();
			sesion.save(f);
			tx.commit();
			System.out.println("Finalizacion con exito... familia introducida");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			sesion.close();
		}
	}

}
