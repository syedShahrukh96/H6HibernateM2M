package Com.shahrukh.hibernate.FirstProject;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 */
public class PersistMain {
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
    	
    
    	//first Employee project with three project and details below
    	List<Project> projectList1 = new ArrayList<>();
    	projectList1.add(new Project("CRM Project"));
    	projectList1.add(new Project("ERP Project"));
    	projectList1.add(new Project("HRM Project"));
    	
    	
    	Employee employee1 = new Employee("Anand", "anand@gmail.com","2345676543");
    	employee1.setProjects(projectList1);
    	session.persist(employee1);
    			
   
    	//Second Employee project with three project and details below
    	List<Project> projectList2 = new ArrayList<>();
    	projectList2.add(session.get(Project.class, 2));
    	projectList2.add(session.get(Project.class, 3));
    	
      	Employee employee2 = new Employee("Anandi", "anandi@gmail.com","334567654345");
    	employee2.setProjects(projectList2);
    	session.persist(employee2);
    	
    	
    	
    	
		tx.commit();
		
		/*
		 * Finally, the Session is closed to free up resources. It is essential to close
		 * the session after the transaction is complete to prevent memory leaks and
		 * other issues.
		 */
		session.close();
		  
    	
    	
    	
    }
}
