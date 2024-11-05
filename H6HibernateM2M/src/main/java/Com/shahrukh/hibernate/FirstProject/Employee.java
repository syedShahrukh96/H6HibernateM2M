package Com.shahrukh.hibernate.FirstProject;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "h6_employee")
// this is a POJO class
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EMPID")
	int empId;
	
	@Column(name = "NAME")
	String empName;
	
	@Column(name = "E-Mail")
	String email;
	
	@Column(name = "PHONE_NUMBER")
	String Phone;
	
	
	//@Column(name = "ADDRESS_ID")
	
	/*
	 * one-to-one relationship between this entity and another entity, in this case,
	 * the Address entity. The cascade = CascadeType.ALL attribute means that any
	 * operation (like persist, remove, update) performed on the parent entity will
	 * be cascaded to the associated Address entity.
	 */
	@ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinTable(name = "emp_project",
				joinColumns  = @JoinColumn(name= "empId"),
				inverseJoinColumns  = @JoinColumn(name= "prjid")
	)
	List<Project> projects;

	public Employee(int empId, String empName, String email, String phone, List<Project> projects) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.email = email;
		Phone = phone;
		this.projects = projects;
	}

	public Employee(int empId, String empName, String email, String phone) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.email = email;
		Phone = phone;
	}

	public Employee(String empName, String email, String phone) {
		super();
		this.empName = empName;
		this.email = email;
		Phone = phone;
	}

	public int getEmpId() {
		return empId;
	}


	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}


	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}


	public List<Project> getProjects() {
		return projects;
	}


	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	//	super() Call:
//		The super() call is an explicit call to the no-argument constructor of the superclass. 
//		Every class in Java implicitly or explicitly extends Object, 
//		so super() refers to the constructor of the direct superclass.
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", email=" + email + ", Phone=" + Phone + "]";
	}







	
	
	
}
