package com.sharma.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sharma.Entity.EmployeeEntity;
import com.sharma.Repository.EmployeeRepository;



@RestController // Define a class as Controller class
@RequestMapping("/api") // Used to map request  to a method  in controller layer/class
public class EmployeeController {
	
	
	@Autowired //used to inject the bean OR for automatic Dependency Injection
	EmployeeRepository employeeRepository;
	
	
	@PostMapping("/employee")
	public String createNewEmployee(@RequestBody EmployeeEntity employeeEntity) {
		employeeRepository.save(employeeEntity);
		return "Employee Created in Database.";
	}
		
	

	@GetMapping("/employee")
//	we will pass the entity class name as a parameter in the list to call and to save the info/record which we have defined in the 
//	entity layer like employee name, id, age, salary etc whatever we have declared in the entity layer
	public ResponseEntity<List<EmployeeEntity>> getAllEmployees(){
		List<EmployeeEntity> empList = new ArrayList<>();
		employeeRepository.findAll().forEach(empList::add);
		return new ResponseEntity<List<EmployeeEntity>>(empList, HttpStatus.OK);
	}
	
	
	
//	 logic/function to get the employee date by employee id
	
//	@GetMapping("/employee/{aid}")
//	public ResponseEntity<EmployeeEntity> getEmployeeById(@PathVariable Long aid){
//		Optional<EmployeeEntity> emp = employeeRepository.findById(aid);
//		if(emp.isPresent()) {
//			return new ResponseEntity<>(emp.get(), HttpStatus.OK); 
//		} else {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
//		
//	}
	@GetMapping("/employee/{id}")
	public ResponseEntity<EmployeeEntity> getEmployeeById(@PathVariable Long id){		
/* What is the use of Optional? Optional is used to avoid NullPointerExceptions by wrapping a value that may be null.
   What if you don't use Optional? You'll need to manually check for null values, increasing the risk of NullPointerExceptions.*/
		Optional<EmployeeEntity> emp = employeeRepository.findById(id);
		if(emp.isPresent()) {
			return new ResponseEntity<>(emp.get(), HttpStatus.OK); 
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@PutMapping("/employee/{id}")
	public String updateEmployeeById(@PathVariable long id, @RequestBody EmployeeEntity employee) {
		Optional<EmployeeEntity> emp = employeeRepository.findById(id);
		if(emp.isPresent()) {
			EmployeeEntity existEmp = emp.get();
			existEmp.setEmp_name(employee.getEmp_name());
			existEmp.setEmp_salary(employee.getEmp_salary());
			existEmp.setEmp_age(employee.getEmp_age());
			existEmp.setEmp_city(employee.getEmp_city());
			employeeRepository.save(existEmp);
			return "Employee Details against Id" + " " + id + " " + "updated";
		} else {
			return "Employee Doesn't exist with Id" + " " + id;
		}
		
	}
	
	@DeleteMapping("/employee")
	public String deleteAllEmployee() {
		employeeRepository.deleteAll();
		return "Employee Deleted Successfully";
	}
	
	
	@DeleteMapping("/employee/{id}")
	public String deleteEmployeeById(@PathVariable long id) {
		employeeRepository.deleteById(id);
		return "Employee Deleted Successfully";
		
	}
	
}

