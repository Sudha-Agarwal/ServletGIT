package Runner;

import java.util.Arrays;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import persistence.Department;
import persistence.Employee;
import persistence.Meeting;

public class AppMain {
	 static Employee empObj;
	    static Session sessionObj;
	    static SessionFactory sessionFactoryObj;
	 
	    private static SessionFactory buildSessionFactory() {
	        // Creating Configuration Instance & Passing Hibernate Configuration File
	        Configuration configObj = new Configuration();
	        configObj.configure("hibernate.cfg.xml");
	 
	        // Since Hibernate Version 4.x, ServiceRegistry Is Being Used
	        ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder().applySettings(configObj.getProperties()).build(); 
	 
	        // Creating Hibernate SessionFactory Instance
	        sessionFactoryObj = configObj.buildSessionFactory(serviceRegistryObj);        
	        
	        return sessionFactoryObj;
	    }
	 
	    public static void main(String[] args) {
	        System.out.println(".......Hibernate Maven Example.......\n");
	        try {
	            sessionObj = buildSessionFactory().openSession();
	            sessionObj.beginTransaction();
	            
	            Department department  = new Department();
	            department.setName("Finance");
	    		
	    		 sessionObj.save(department);
	 
	            Employee e1=new Employee();   
	         
	            e1.setFirstName("Sudha");    
	            e1.setLastName("Agarwal");  
	            e1.setDepartment(department );
	            
	            Employee e2=new Employee();   
		         
	            e2.setFirstName("Sudha1");    
	            e2.setLastName("Agarwal1"); 
	            e2.setDepartment(department );
	            
	            department.setEmp(Arrays.asList(e1,e2));                    
	           	                   
	            Meeting meeting1 = new Meeting("Quaterly Sales meeting");
	            Meeting meeting2 = new Meeting("Weekly Status meeting");
	            
	            e1.getMeetings().add(meeting1);
	            e1.getMeetings().add(meeting2);
	            
	            e2.getMeetings().add(meeting2);
	            
	            sessionObj.save(e1); 
	            sessionObj.save(e2); 
	            
	            
	            System.out.println("\n.......Records Saved Successfully To The Database.......\n");
	 
	            // Committing The Transactions To The Database
	            sessionObj.getTransaction().commit();
	        } catch(Exception sqlException) {
	            if(null != sessionObj.getTransaction()) {
	                System.out.println("\n.......Transaction Is Being Rolled Back.......");
	                sessionObj.getTransaction().rollback();
	            }
	            sqlException.printStackTrace();
	        } finally {
	            if(sessionObj != null) {
	                sessionObj.close();
	            }
	        }
	    }

}
