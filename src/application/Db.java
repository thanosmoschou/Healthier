package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import javafx.collections.ObservableList;
import javafx.scene.control.Alert.AlertType;

public class Db 
{
	
	//credentials for db
	private static String usernameForDb = "root"; //be careful with the db credentials...you should not be connected as root
	private static String passwordForDb = "";
	
	private static Connection connection;
	private static PreparedStatement preparedStmt;
	
	public Db()
	{	
	}
	
	
	public static boolean storeUserToDb(Doctor doctor)
	{
		//store to db
		String username = doctor.getUsername();
		String password = doctor.getPassword();
		String email = doctor.getEmail();
		String ssn = doctor.getSsn();
		String phone = doctor.getPhone();
			
		try
		{
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/health", usernameForDb, passwordForDb);
			
			String query = "insert into doctors values (?, ?, ?, ?, ?)";
			
			preparedStmt = connection.prepareStatement(query);
			preparedStmt.setString(1, username);
			preparedStmt.setString(2, password);
			preparedStmt.setString(3, email);
			preparedStmt.setString(4, ssn);
			preparedStmt.setString(5, phone);
			preparedStmt.execute();
			
			AlertMessages.createAlertWindow(AlertMessages.REGISTRATION_SUCCESS, AlertMessages.REGISTRATION_SUCCESS_MESSAGE, AlertType.INFORMATION);
			
			preparedStmt.close();
			connection.close();
			
			return true;
			
		} 
		catch(SQLIntegrityConstraintViolationException e)
		{
			AlertMessages.createAlertWindow(AlertMessages.REGISTRATION_FAILED, AlertMessages.DOCTOR_ALREADY_EXISTS, AlertType.ERROR);
			e.printStackTrace();
		}
		catch(SQLException e) 
		{
			AlertMessages.createAlertWindow(AlertMessages.REGISTRATION_FAILED, AlertMessages.SOMETHING_WENT_WRONG, AlertType.ERROR);
			e.printStackTrace();
		}
		
		return false;
	}
	
	
	public static Doctor fetchUserFromDb(String aUsername, String aPassword)
	{
		try 
		{
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/health", usernameForDb, passwordForDb);
			
			String query = "select * from doctors where username = ? and password = ?";
			
			preparedStmt = connection.prepareStatement(query);
			preparedStmt.setString(1, aUsername);
			preparedStmt.setString(2, aPassword);
			preparedStmt.execute();
			
			ResultSet res = preparedStmt.getResultSet();
			Doctor doc = null;
			
			if(res.next())
			{
				doc = Doctor.getInstance();
				Doctor.setDoctorsData(res.getString("username"), res.getString("password"), res.getString("email"), res.getString("doctorSSN"), res.getString("phone"));
			}
			
			preparedStmt.close();
			connection.close();
			
			return doc;
		} 
		catch(SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return null;
	}
	
	public static void storeAppointmentToDb(String firstName, String lastName, String email, String ssn, String phone, String date)
	{
		try 
		{
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/health", usernameForDb, passwordForDb);
			String query = "insert into appointments values (?, ?, ?, ?, ?, ?)";
			
			preparedStmt = connection.prepareStatement(query);
			preparedStmt.setString(1, firstName);
			preparedStmt.setString(2, lastName);
			preparedStmt.setString(3, email);
			preparedStmt.setString(4, ssn);
			preparedStmt.setString(5, phone);
			preparedStmt.setString(6, date);
			preparedStmt.execute();

			
			AlertMessages.createAlertWindow(AlertMessages.APPOINTMENT_BOOKING_SUCCESS, AlertMessages.APPOINTMENT_BOOKING_SUCCESS_MESSAGE, AlertType.INFORMATION);
			
		} 
		catch(SQLException e) 
		{
			AlertMessages.createAlertWindow(AlertMessages.APPOINTMENT_BOOKING_FAILED, AlertMessages.APPOINTMENT_BOOKING_FAILED_MESSAGE, AlertType.ERROR);
			e.printStackTrace();
		}
		
	}
	
	public static ObservableList<String> fetchReservationsFromDb(String date)
	{
		//fetch from db
		return null;
	}
	
}
