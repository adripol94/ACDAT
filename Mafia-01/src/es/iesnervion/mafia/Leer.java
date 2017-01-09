package es.iesnervion.mafia;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import es.iesnervion.mafia.model.Famiglias;

public class Leer {
	private static SessionFactory sessionFactory = null;
	
	public static void getRows() {
		Session sesion = null;
		try {
				sessionFactory = Mafiafactory.getSessionFactory();
				sesion = sessionFactory.openSession();
				
				//TODO Arreglar esto!
				@SuppressWarnings("unchecked")
				List<Famiglias> listado  = sesion.createQuery("from Famiglias")
						 .list();
				
				
				
				for (Famiglias f : listado)
					System.out.println(f);
				
							
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sesion.close();
		} 
		
	}

}
