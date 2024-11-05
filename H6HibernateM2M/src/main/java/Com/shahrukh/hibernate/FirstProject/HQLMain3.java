package Com.shahrukh.hibernate.FirstProject;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class HQLMain3 {

	  public static void main(String[] args) {
	    	
	    	
	
	    	Configuration cfg = new Configuration().configure();
	    	
	    	SessionFactory factory =cfg.buildSessionFactory();
	 
	    	Session session = factory.openSession();
	  
	    	Transaction tx = session.beginTransaction();
	    	
	    	
			/*
			 * Query<Employee> qry = session.createQuery("From Employee"); List<Employee>
			 * empList = qry.getResultList();
			 * //with lamda 
			  empList.forEach(emp -> System.out.println(emp));
			 */
	    	
	    	
	    	//to retrive the emp data with them name. with parameter
	    	Query<Employee> qry1 = session.createQuery("From Employee ");
	    	qry1.setFirstResult(2); //it will set the first result from which it have to print
	    	qry1.setMaxResults(1); // it will print the number of result
	    	List<Employee> empList1 = qry1.list();
	    	empList1.forEach(emp1 -> System.out.println(emp1));

			
			  
			 
	    	
	
			tx.commit();
			session.close();
			  
	
}
}
