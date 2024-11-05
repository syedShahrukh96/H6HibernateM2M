package Com.shahrukh.hibernate.FirstProject;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class HQLMain {

	  public static void main(String[] args) {
	    	
	    	
	
	    	Configuration cfg = new Configuration().configure();
	    	
	    	SessionFactory factory =cfg.buildSessionFactory();
	 
	    	Session session = factory.openSession();
	  
	    	Transaction tx = session.beginTransaction();
	    	
	    	
			
			  Query<Employee> qry = session.createQuery("From Employee"); 
			  List<Employee> empList = qry.getResultList();
			  //with lamda 
			  empList.forEach(emp -> System.out.println(emp));
			 
	    	
	 

			
			  
			 
	    	
	
			tx.commit();
			session.close();
			  
	
}
}
