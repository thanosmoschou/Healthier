package application.controllers;

import java.io.IOException;

import application.AlertMessages;
import application.Db;
import application.Doctor;
import application.Validator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SignUpController
{
	@FXML
	private Button signUpButton;
	@FXML
	private Button cancelButton;
	@FXML
	private TextField usernameField;
	@FXML
	private PasswordField passwordField;
	@FXML
	private TextField emailField;
	@FXML
	private TextField ssnField;
	@FXML
	private TextField phoneField;
		
	
	private Stage stage;
	private Scene scene;
	private Parent root;	
	
	
	public void retrieveData(ActionEvent e) throws IOException
	{		
		String usernameAsAString = usernameField.getText();
		String passwordAsAString = passwordField.getText();
		String emailAsAString = emailField.getText();
		String ssnAsAString = ssnField.getText();
		String phoneAsAString = phoneField.getText();
		
		if(checkValidityOfData(usernameAsAString, passwordAsAString, emailAsAString, ssnAsAString, phoneAsAString))
		{
			Doctor doctor = Doctor.getInstance();
			Doctor.setDoctorsData(usernameAsAString, passwordAsAString, emailAsAString, ssnAsAString, phoneAsAString);
			boolean success = Db.storeUserToDb(doctor);
			if(success)
				goToNewAppointmentScene(e);
		}
		
	}
	
	
	//Just a simple check if ssn is digits, if email contains @ and . and if phone is digits
	private boolean checkValidityOfData(String username, String password, String email, String ssn, String phone)
	{
		
		if(!Validator.isUsernameValid(username))
		{
			AlertMessages.createAlertWindow(AlertMessages.REGISTRATION_FAILED, AlertMessages.EMPTY_USERNAME_ALERT, AlertType.ERROR);
			return false;
		}
		
		if(!Validator.isPasswordValid(password))
		{
			AlertMessages.createAlertWindow(AlertMessages.REGISTRATION_FAILED, AlertMessages.INVALID_PASSWORD_ALERT, AlertType.ERROR);
			return false;
		}
		
		if(!Validator.isEmailValid(email))
		{
			AlertMessages.createAlertWindow(AlertMessages.REGISTRATION_FAILED, AlertMessages.INVALID_EMAIL_ALERT, AlertType.ERROR);
			return false;
		}
		
		if(!Validator.isSSNValid(ssn))
		{
			AlertMessages.createAlertWindow(AlertMessages.REGISTRATION_FAILED, AlertMessages.INVALID_SSN_ALERT, AlertType.ERROR);
			return false;
		}
		
		if(!Validator.isPhoneValid(phone))
		{
			AlertMessages.createAlertWindow(AlertMessages.REGISTRATION_FAILED, AlertMessages.INVALID_PHONE_ALERT, AlertType.ERROR);
			return false;
		}
		
		return true;
	}
	
	
	public void returnToLoginPage(ActionEvent e) throws IOException
	{
		Node node = (Node) e.getSource(); //get the source of the event

		root = FXMLLoader.load(this.getClass().getResource("../scenes/LoginScene.fxml"));
		scene = new Scene(root, 600, 600);
		scene.getStylesheets().add(this.getClass().getResource("../css/login.css").toExternalForm());
		
		stage = (Stage) node.getScene().getWindow(); //get the stage of the node
		stage.setScene(scene);
		stage.show();
	}
	
	
	private void goToNewAppointmentScene(ActionEvent e) throws IOException
	{
		Node node = (Node) e.getSource(); //get the source of the event

		root = FXMLLoader.load(this.getClass().getResource("../scenes/NewAppointmentScene.fxml"));
		scene = new Scene(root, 860, 670);
		scene.getStylesheets().add(this.getClass().getResource("../css/newAppointment.css").toExternalForm());
		
		stage = (Stage) node.getScene().getWindow(); //get the stage of the node
		stage.setScene(scene);
		stage.show();
	}
	
	
}
