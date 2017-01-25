package es.iesnervion;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import es.iesnervion.model.*;

public class BichosFactory {
	private static ServiceRegistry serviceRegistry;
    private static final SessionFactory sessionFactory;
    
	static {
		try {
			Configuration config = new Configuration().configure();
			config.addAnnotatedClass(Cliente.class);
			config.addAnnotatedClass(Enfermedad.class);
			config.addAnnotatedClass(EnfermedadMascota.class);
			config.addAnnotatedClass(Mascota.class);
			config.addAnnotatedClass(Visita.class);
			
			StandardServiceRegistryBuilder srb = new StandardServiceRegistryBuilder();
			
			srb.applySettings(config.getProperties());
			
			serviceRegistry = srb.build();
			sessionFactory = config.buildSessionFactory(serviceRegistry);
			
		} catch (Throwable ex) {
			ex.printStackTrace();
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
