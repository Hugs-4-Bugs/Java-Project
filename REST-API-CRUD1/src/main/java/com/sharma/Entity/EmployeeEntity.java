package com.sharma.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity  //used to mark a class as JPA entity
@Table(name="employee")  //@Table is use to mark/specify the table in the entity layer
public class EmployeeEntity {
	
	
	
/*
public EmployeeEntity() { super(); }
Use: This is a default constructor (no-arg constructor) that allows Hibernate to instantiate the EmployeeEntity class.

What happens if not written:
// Without this constructor, Hibernate will throw an error because it requires a default constructor to instantiate the entity class.
*/
 
	 public EmployeeEntity() {      		 
	        super();
	    }

	
	@Id //use to mark a field ad the the primary key of the entity
	@GeneratedValue(strategy = GenerationType.IDENTITY) // @GeneratedValue is used to specify how primary key value is generated
	
	private Long empid;
	
	@Column(name="emp_name") //@Column is used to specify the name and other attribute for a field in an entity layer
	private String emp_name;
	
	@Column(name="emp_salary")
	private Float emp_salary;
	
	@Column(name="emp_age")
	private int emp_age;
	
	@Column(name="emp_city")
	private String emp_city;
	
	
	public Long getEmpid() {  //created a method named "getEmpid" to get the unique employee id every time.
		return empid;
	}
	public void setEmpid(Long empid) {
		this.empid = empid;
	}


	public String getEmp_name() {
		return emp_name;
	}


	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}


	public Float getEmp_salary() {
		return emp_salary;
	}


	public void setEmp_salary(Float emp_salary) {
		this.emp_salary = emp_salary;
	}


	public int getEmp_age() {
		return emp_age;
	}


	public void setEmp_age(int emp_age) {
		this.emp_age = emp_age;
	}


	public String getEmp_city() {
		return emp_city;
	}


	public void setEmp_city(String emp_city) {
		this.emp_city = emp_city;
	}


	

	public EmployeeEntity(Long empid, String emp_name, Float emp_salary, int emp_age, String emp_city) {
		super();
		this.empid = empid;
		this.emp_name = emp_name;
		this.emp_salary = emp_salary;
		this.emp_age = emp_age;
		this.emp_city = emp_city;
	}


	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", emp_name=" + emp_name + ", emp_salary=" + emp_salary + ", emp_age="
				+ emp_age + ", emp_city=" + emp_city + "]";
	}
	
	
}
