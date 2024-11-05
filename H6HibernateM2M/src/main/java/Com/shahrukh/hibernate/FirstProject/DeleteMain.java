package Com.shahrukh.hibernate.FirstProject;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class DeleteMain {

	  public static void main(String[] args) {
	    	
	    	
			/*
			 * This line creates a Configuration object and configures it using the
			 * hibernate.cfg.xml file (or other configuration files specified). This
			 * configuration file contains all the database connection settings, mappings,
			 * and other Hibernate-related configurations.
			 */
	    	Configuration cfg = new Configuration().configure();
	    	
			/*
			 * The SessionFactory is a factory for Session objects. It is a heavyweight
			 * object that is created once during the application startup and used to create
			 * Session objects throughout the application. It is built using the
			 * configuration from the Configuration object.
			 */
	    	SessionFactory factory =cfg.buildSessionFactory();
	    	
			/*
			 * This line opens a new Session from the SessionFactory. A Session is the
			 * primary nterface for performing CRUD (Create, Read, Update, Delete)
			 * operations on the database using Hibernate. It is a lightweight object that
			 * should be created and closed with each database transaction.
			 */
	    	Session session = factory.openSession();
	    	
			/*
			 * This line begins a new transaction. In Hibernate, you need to explicitly
			 * start and commit transactions to ensure that your operations (like saving an
			 * entity) are executed atomically and consistently.
			 */
	    	Transaction tx = session.beginTransaction();

	    	
	    	 Employee empDel = session.get(Employee.class, 1);
	    	 session.remove(empDel);
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	
			tx.commit();
			
			/*
			 * Finally, the Session is closed to free up resources. It is essential to close
			 * the session after the transaction is complete to prevent memory leaks and
			 * other issues.
			 */
			session.close();
			  
	
}
}
