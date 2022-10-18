package DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import Runner.AppMain;
import hibernateUtil.HibernateUtil;
import persistence.Employee;

public class EmployeeDAOImpl implements EmployeeDAO {
	
	   SessionFactory sessionFactoryObj = HibernateUtil.getSessionFactory();
		Session sessionObj = sessionFactoryObj.getCurrentSession();

	public void addEmployee(Employee employee) {
		sessionObj = sessionFactoryObj.getCurrentSession();
		sessionObj.getTransaction().begin();
	    sessionObj.saveOrUpdate(employee);
	    sessionObj.getTransaction().commit();	
	    //sessionObj.close();
	}

	@SuppressWarnings("unchecked")
	public List<Employee> getEmployees() {
		 return (List<Employee>) sessionFactoryObj.openSession().createCriteria(Employee.class).list();
	}

	public Employee getEmployee(int id) {
		return (Employee) sessionFactoryObj.getCurrentSession().get(Employee.class, id);
	}

	public void deleteEmployee(int id) {
		sessionFactoryObj.getCurrentSession().createQuery("DELETE FROM Employee WHERE id = "+id).executeUpdate();
		
	}
	
	public void updateEmployee(int id) {
		
	}

}
