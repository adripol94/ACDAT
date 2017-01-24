package es.iesnervion;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Main {
	private static SessionFactory sessionfactory = null;
	
	public static void main(String[] args) {
		read();

	}

	private static void read() {
		Session s = null;
		try {
			sessionfactory = BichosFactory.getSessionFactory();
			s = sessionfactory.openSession();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			s.close();
		}
	}

}
