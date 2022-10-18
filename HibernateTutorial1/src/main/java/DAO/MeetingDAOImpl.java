package DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hibernateUtil.HibernateUtil;
import persistence.Department;
import persistence.Meeting;

public class MeetingDAOImpl implements MeetingDAO{
	SessionFactory sessionFactoryObj = HibernateUtil.getSessionFactory();
	Session sessionObj = sessionFactoryObj.getCurrentSession();


	public void addMeeting(Meeting meeting) {
		// TODO Auto-generated method stub

	}

	public List<Meeting> getMeetings() {
		// TODO Auto-generated method stub
		return null;
	}

	public Meeting getMeeting(long id) {
		sessionObj = sessionFactoryObj.getCurrentSession();
		sessionObj.getTransaction().begin();				
		//sessionFactoryObj.getCurrentSession().createQuery("select*  FROM department WHERE id = "+id).executeUpdate();
		Meeting meeting =  (Meeting) sessionObj.get(Meeting.class, id);
		sessionObj.getTransaction().commit();
		return meeting;
	}

	public void deleteMeeting(long id) {
		// TODO Auto-generated method stub

	}

}
