/*
 * Author: Thanos Moschou
 * Description: This is a doctor appointment app written in Java by
 * using JavaFX.
 * Last Modification Date: 10/12/2023
 */

package application.controllers;

import java.io.IOException;
import java.time.LocalDate;

import application.AlertMessages;
import application.Db;
import application.Validator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class NewAppointmentController 
{	
	@FXML
	private Button logoutButton;
	@FXML
	private TextField firstNameField;
	@FXML
	private TextField lastNameField;
	@FXML
	private TextField emailField;
	@FXML
	private TextField ssnField;
	@FXML
	private TextField phoneField;
	@FXML
	private DatePicker dateField;	
		
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	//Date needs to be specified in order not to receive a runtime exception from the DatePicker
	public void scheduleAppointment()
	{
		setDateToDateField();
		
		String firstNameAsAString = firstNameField.getText();
		String lastNameAsAString = lastNameField.getText();
		String emailAsAString = emailField.getText();
		String patientSSNAsAString = ssnField.getText();
		String phoneAsAString = phoneField.getText();
		String dateAsAString = dateField.getValue().toString();
		
		if(checkValidityOfData(firstNameAsAString, lastNameAsAString, emailAsAString, patientSSNAsAString, phoneAsAString, dateAsAString))
			Db.storeAppointmentToDb(firstNameAsAString, lastNameAsAString, emailAsAString, patientSSNAsAString, phoneAsAString, dateAsAString);
		else
		{
			System.out.println(Validator.getProblemCode()); //see what is the problem with the fields
			AlertMessages.createAlertWindow(AlertMessages.APPOINTMENT_BOOKING_FAILED, AlertMessages.EMPTY_APPOINTMENT_FIELDS_MESSAGE, AlertType.ERROR);
		}
		
	}
	
	public void setDateToDateField()
	{
		if(dateField.getValue() == null)
			dateField.setValue(LocalDate.now());
	}
	
	
	public void clearFields()
	{
		firstNameField.setText("");
		lastNameField.setText("");
		emailField.setText("");
		ssnField.setText("");
		phoneField.setText("");
		dateField.setValue(null);	
	}
	
	
	private boolean checkValidityOfData(String firstName, String lastName, String email, String ssn, String phone, String date)
	{
		if(!Validator.isFirstNameValid(firstName))
		{
			AlertMessages.createAlertWindow(AlertMessages.APPOINTMENT_BOOKING_FAILED, AlertMessages.EMPTY_FIRSTNAME_MESSAGE, AlertType.ERROR);
			return false;
		}
		
		if(!Validator.isLastNameValid(lastName))
		{
			AlertMessages.createAlertWindow(AlertMessages.APPOINTMENT_BOOKING_FAILED, AlertMessages.EMPTY_LASTNAME_MESSAGE, AlertType.ERROR);
			return false;
		}
		
		if(!Validator.isEmailValid(email))
		{
			AlertMessages.createAlertWindow(AlertMessages.APPOINTMENT_BOOKING_FAILED, AlertMessages.INVALID_EMAIL_MESSAGE, AlertType.ERROR);
			return false;
		}
		
		if(!Validator.isSSNValid(ssn))
		{
			AlertMessages.createAlertWindow(AlertMessages.APPOINTMENT_BOOKING_FAILED, AlertMessages.INVALID_SSN_MESSAGE, AlertType.ERROR);
			return false;
		}
		
		if(!Validator.isPhoneValid(phone))
		{
			AlertMessages.createAlertWindow(AlertMessages.APPOINTMENT_BOOKING_FAILED, AlertMessages.INVALID_PHONE_MESSAGE, AlertType.ERROR);
			return false;
		}
		
		if(!Validator.isDateValid(date))
		{
			AlertMessages.createAlertWindow(AlertMessages.APPOINTMENT_BOOKING_FAILED, AlertMessages.EMPTY_DATE_MESSAGE, AlertType.ERROR);
			return false;
		}
		
		return true;
	}
	
	
	public void changeToMyAppointmentsScene(ActionEvent e)
	{
		Node node = (Node) e.getSource();
				
		try 
		{
			
			root = FXMLLoader.load(this.getClass().getResource("../scenes/MyAppointmentsScene.fxml"));
			
			scene = new Scene(root, 860, 670);
			scene.getStylesheets().add(this.getClass().getResource("../css/myAppointments.css").toExternalForm());
			
			stage = (Stage) node.getScene().getWindow();
			stage.setScene(scene);
			stage.show();
		} 
		catch (IOException ev) 
		{
			ev.printStackTrace();
		}
	}
	
	
	public void logout(ActionEvent e)
	{
		Node node = (Node) e.getSource();
		
		try 
		{
			root = FXMLLoader.load(this.getClass().getResource("../scenes/LoginScene.fxml"));
			
			scene = new Scene(root, 600, 600);
			scene.getStylesheets().add(this.getClass().getResource("../css/login.css").toExternalForm());
			
			stage = (Stage) node.getScene().getWindow();
			stage.setScene(scene);
			stage.show();
		} 
		catch (IOException ev) 
		{
			ev.printStackTrace();
		}
	}
}
