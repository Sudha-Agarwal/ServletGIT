package com.learning.DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.learning.Bean.Employee;

public class EmployeeDAO {
	
	public static Connection getConnection() {
		Connection con = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/simplilearn","root","root");
			
		}
		catch(Exception e) {
			System.out.println(e);
			
		}
		return con;
		
	}

    public static int registerEmployee(Employee employee) throws ClassNotFoundException {
        String INSERT_USERS_SQL = "INSERT INTO employee" +
            "  (first_name, last_name, username, password, address, contact) VALUES " +
            " (?, ?, ?, ?, ?,?,?);";

        int result = 0;
       
        try {
        	
        	Connection connection = EmployeeDAO.getConnection();
        	
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);
           
            preparedStatement.setString(1, employee.getFirstName());
            preparedStatement.setString(2, employee.getLastName());
            preparedStatement.setString(3, employee.getUsername());
            preparedStatement.setString(4, employee.getPassword());
            preparedStatement.setString(5, employee.getAddress());
            preparedStatement.setString(6, employee.getContact());

            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            result = preparedStatement.executeUpdate();
            

        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        return result;
    }
    
	/*
	 * public static List<Employee> getAllEmployees(){ List<Employee> list=new
	 * ArrayList<Employee>();
	 * 
	 * try{ Connection con=EmployeeDAO.getConnection(); PreparedStatement
	 * ps=con.prepareStatement("select * from employee"); ResultSet
	 * rs=ps.executeQuery(); while(rs.next()){ Employee e=new Employee();
	 * e.setFirstName(rs.getString(2)); e.setLastName(rs.getString(3));
	 * e.setUsername(rs.getString(4)); e.setPassword(rs.getString(5));
	 * e.setAddress(rs.getString(6)); e.setContact(rs.getString(7)); list.add(e); }
	 * con.close(); }catch(Exception e){e.printStackTrace();}
	 * 
	 * return list; }
	 */
    
    public static List<Employee> getAllEmployeesCallable(){  
        List<Employee> list=new ArrayList<Employee>();  
          
        try{  
            Connection con=EmployeeDAO.getConnection();  
            
            CallableStatement stmt=con.prepareCall("{call GetEmployeeDetails()}");  
            
            //stmt.execute(); 
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){  
            	Employee e=new Employee();  
                e.setFirstName(rs.getString(2));  
                e.setLastName(rs.getString(3));  
                e.setUsername(rs.getString(4));  
                e.setPassword(rs.getString(5));  
                e.setAddress(rs.getString(6));
                e.setContact(rs.getString(7));
                list.add(e);  
            }            
            con.close();             
        }catch(Exception e){e.printStackTrace();}  
          
        return list;  
    }  
    
    public static Employee getAllEmployeeByIdCallable(int id){  
       
    	Employee emp=new Employee();  
        try{  
            Connection con=EmployeeDAO.getConnection();  
            
            CallableStatement stmt=con.prepareCall("{call GetEmployeeDetailsById(?)}");  
            stmt.setInt(1, id);
            
            //stmt.execute(); 
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){  
            	
            	emp.setFirstName(rs.getString(2));  
            	emp.setLastName(rs.getString(3));  
            	emp.setUsername(rs.getString(4));  
            	emp.setPassword(rs.getString(5));  
            	emp.setAddress(rs.getString(6));
            	emp.setContact(rs.getString(7));
               
            }            
            con.close();             
        }catch(Exception e){e.printStackTrace();}  
          
        return emp;  
    }  

    private static void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}