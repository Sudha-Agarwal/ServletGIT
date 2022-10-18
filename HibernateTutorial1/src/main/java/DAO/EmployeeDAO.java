package DAO;

import java.util.List;

import persistence.Employee;

public interface EmployeeDAO {
	
	public void addEmployee(Employee employee);
	 
	 public List<Employee> getEmployees();
	 
	 public Employee getEmployee(int id);
	 
	 public void deleteEmployee(int id);

}
