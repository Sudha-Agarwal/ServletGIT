package DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import Runner.AppMain;
import hibernateUtil.HibernateUtil;
import persistence.Department;

public class DepartmentDAOImpl implements DepartmentDAO{

	//static SessionFactory sessionFactoryObj = new AppMain().buildSessionFactory();    
	//Session sessionObj;

	SessionFactory sessionFactoryObj = HibernateUtil.getSessionFactory();
	Session sessionObj = sessionFactoryObj.getCurrentSession();

	public void addEmployee(Department department) {
		// TODO Auto-generated method stub

	}

	public List<Department> getDepartments() {
		// TODO Auto-generated method stub
		return null;
	}

	public Department getDepartment(int id) {
		sessionObj = sessionFactoryObj.getCurrentSession();
		sessionObj.getTransaction().begin();
		/*Query query = sessionObj.createQuery("from Department where id= :id");
		query.setInteger("id", 14);
		Department dept = (Department) query.uniqueResult();
		return dept;*/


		//sessionFactoryObj.getCurrentSession().createQuery("select*  FROM department WHERE id = "+id).executeUpdate();
		Department dept =  (Department) sessionObj.get(Department.class, id);
		sessionObj.getTransaction().commit();
		return dept;
	}

	public void deleteDepartment(int id) {
		// TODO Auto-generated method stub

	}

}
