package Com.shahrukh.hibernate.FirstProject;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class HQLMain2 {

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
	    	Query<Employee> qry1 = session.createQuery("From Employee where empName =?1 ");
	    	qry1.setParameter(1, "Anand");
	    	List<Employee> empList1 = qry1.list();
	    	empList1.forEach(emp1 -> System.out.println(emp1));

			
			  
			 
	    	
	
			tx.commit();
			session.close();
			  
	
}
}
