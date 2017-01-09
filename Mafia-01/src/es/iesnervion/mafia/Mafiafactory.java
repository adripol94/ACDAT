package es.iesnervion.mafia;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import es.iesnervion.mafia.model.Don;
import es.iesnervion.mafia.model.Famiglias;

public class Mafiafactory {
	 private static ServiceRegistry serviceRegistry;
	    private static final SessionFactory sessionFactory;
	 
	    static {
	        try {
	Configuration configuration=new Configuration()
	            .configure(); // configures settings from hibernate.cfg.xml
	configuration.addAnnotatedClass(Famiglias.class);
	configuration.addAnnotatedClass(Don.class);
	
	    StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();

	    // If you miss the below line then it will complaing about a missing dialect setting
	    serviceRegistryBuilder.applySettings(configuration.getProperties());

	    serviceRegistry = (ServiceRegistry) serviceRegistryBuilder.build();
	    sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	        } catch (Throwable ex) {
	            System.err.println("Failed to create sessionFactory object." + ex);
	            throw new ExceptionInInitializerError(ex);
	        }
	    }
	 
	    public static SessionFactory getSessionFactory() {
	        return sessionFactory;
	    }

}
