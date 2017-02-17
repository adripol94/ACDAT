package es.iesnervion;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import es.iesnervion.model.Visita;

public class Main {
	private static SessionFactory sessionfactory = null;
	
	public static void main(String[] args) {
		read();
		System.out.println("Finish");
	}

	private static void read() {
		Session s = null;
		try {
			sessionfactory = BichosFactory.getSessionFactory();
			s = sessionfactory.openSession();
			
			Set<Visita> visitas = (Set<Visita>) s.createQuery("SELECT v FROM dbo.BI_Visitas v").list();
			for (Visita v : visitas)
				System.out.println(v);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			s.close();
		}
	}

}
