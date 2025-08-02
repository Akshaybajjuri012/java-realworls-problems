package mydaofiles;
import mypojos.Item;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
public class HibernateUtil {
	 private static final SessionFactory sessionFactory;

	    static {
	        try {
	            
	        	Configuration configuration = new Configuration().configure("wiprohibernate.cfg.xml");
	            configuration.addAnnotatedClass(Item.class);

	            sessionFactory = configuration.buildSessionFactory();
	        } catch (Throwable ex) {
	            System.err.println("Initial SessionFactory creation failed." + ex);
	            throw new ExceptionInInitializerError(ex);
	        }
	    }
	    public static SessionFactory getSessionFactory() {
	        return sessionFactory;
	    }

}
