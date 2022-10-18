package DAO;

import java.util.List;

import persistence.Department;

public interface DepartmentDAO {
	public void addEmployee(Department department);
	 
	 public List<Department> getDepartments();
	 
	 public Department getDepartment(int id);
	 
	 public void deleteDepartment(int id);

}
