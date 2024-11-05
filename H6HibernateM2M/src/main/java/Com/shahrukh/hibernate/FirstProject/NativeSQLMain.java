package Com.shahrukh.hibernate.FirstProject;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class NativeSQLMain {

	  public static void main(String[] args) {
	    	
	    	
	
	    	Configuration cfg = new Configuration().configure();
	    	
	    	SessionFactory factory =cfg.buildSessionFactory();
	 
	    	Session session = factory.openSession();
	  
	    	Transaction tx = session.beginTransaction();
	    	
	    	
	    	
	    	String sql = "select * from h6_employee";
	    	
	    	NativeQuery<Employee> empQry = session.createNativeQuery(sql, Employee.class);
	    	empQry.list().forEach(System.out::println);

			
			  
			 
	    	
	
			tx.commit();
			session.close();
			  
	
}
}
