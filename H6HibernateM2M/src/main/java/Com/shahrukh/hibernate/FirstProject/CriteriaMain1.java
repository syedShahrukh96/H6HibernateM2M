package Com.shahrukh.hibernate.FirstProject;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class CriteriaMain1 {

	  public static void main(String[] args) {
	    	
	    	
	
	    	Configuration cfg = new Configuration().configure();
	    	
	    	SessionFactory factory =cfg.buildSessionFactory();
	 
	    	Session session = factory.openSession();
	  
	    	Transaction tx = session.beginTransaction();
	    	
	    	

//	List<Employee> empList = emps.list();
//	empList.forEach(e -> System.out.println(e));
//
//			
//			  
//	List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
//	// Using Predicate to filter numbers
//	List<Integer> evenNumbers = numbers.stream()
//	                                   .filter(n -> n % 2 == 0)
//	                                   .collect(Collectors.toList());
	
	    	
	    	
	    	
	    	//CriteriaBuilder: A tool to build queries in a safe way.
	    	CriteriaBuilder cb = session.getCriteriaBuilder();
	    	
	    	//CriteriaQuery: Represents the actual query you want to run, which in this case fetches Employee entities.
	    	//createQuery: Prepares the query to be executed.
	    	CriteriaQuery<Employee> crt = cb.createQuery(Employee.class);
	    	
	    	
	    	//Root: Represents the main table/entity in the query.
	    	Root<Employee> root = crt.from(Employee.class);
	    	//select: Specifies that you want all the fields of the entity.
	    	crt.select(root);
	    	
	    	
	    	
	    	//Predicate: A condition or filter that you apply to the query.
	    	//cb.equal: Creates a condition that checks if a specific field matches a given value.
	    	Predicate pr = cb.equal(root.get("empName"), "Anand");
	    	
	    	//where: Applies the condition to the query so that only matching records are returned.
	    	crt.where(pr);
	    	
	    	Query<Employee> emps = session.createQuery(crt);
	    	List<Employee> empList = emps.list();
	    	empList.forEach(e -> System.out.println(e));
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
			tx.commit();
			session.close();
			  
	
}
}
