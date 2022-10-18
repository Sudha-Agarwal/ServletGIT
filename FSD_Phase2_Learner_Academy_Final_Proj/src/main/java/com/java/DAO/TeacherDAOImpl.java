package com.java.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.java.persistence.Class;
import com.java.persistence.Teacher;

import hibernateUtil.HibernateUtil;


public class TeacherDAOImpl implements TeacherDAO{
	SessionFactory sessionFactoryObj = HibernateUtil.getSessionFactory();
	Session sessionObj;

	@SuppressWarnings("finally")
	@Override
	public int addTeacher(Teacher teacher) {
		try {
			sessionObj = sessionFactoryObj.openSession();
			sessionObj.getTransaction().begin();
			sessionObj.saveOrUpdate(teacher);
			sessionObj.getTransaction().commit();
		}
		catch(Exception ex) {
			if(null != sessionObj.getTransaction()) {
				System.out.println("\n.......Transaction Is Being Rolled Back.......");
				sessionObj.getTransaction().rollback();
				return 0;
			}
		}
		finally {
			sessionObj.close();
			return 1;
		}
	}

	@Override
	public List<Teacher> getTeacher() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getTeacher(int teacherId) {
		sessionObj = sessionFactoryObj.openSession();
		//sessionObj.getTransaction().begin();	
		Query q=sessionObj.createQuery("select * from Teacher where teacher_id=:i");  
		q.setParameter("i",teacherId);  
		
		return sessionObj.createQuery("select *  FROM teacher WHERE teacher_id = "+teacherId).executeUpdate();
		//Teacher teacher =  (Teacher) sessionObj.get(Teacher.class, teacherId);
		//sessionObj.getTransaction().commit();
		//return teacher;
				
	}

	@Override
	public void deleteTeacher(int id) {
		// TODO Auto-generated method stub
		
	}

}
