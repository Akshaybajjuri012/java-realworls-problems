package mydaofiles;
import mypojos.Account;
import mypojos.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
public class HibernateSessionFactory {
	private static final SessionFactory sessionFactory;

    static {
        try {
            Configuration config = new Configuration().configure("wiprohibernate.cfg.xml");
            config.addAnnotatedClass(Account.class);
            config.addAnnotatedClass(Transaction.class);
            sessionFactory = config.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}
