package application.controllers;

import java.io.IOException;

import application.AlertMessages;
import application.Db;
import application.Doctor;
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

public class LoginController
{
	@FXML
	private Button signUpButton;
	@FXML
	private TextField usernameField;
	@FXML
	private PasswordField passwordField;
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	
	public void retrieveData(ActionEvent e) throws IOException
	{
		String usernameAsAString = usernameField.getText();
		String passwordAsAString = passwordField.getText();
		
		if(areFieldsFilled(usernameAsAString, passwordAsAString))
		{
			Doctor loggedIn = (Doctor) Db.fetchUserFromDb(usernameAsAString, passwordAsAString);
			
			if(loggedIn == null)
				AlertMessages.createAlertWindow(AlertMessages.LOGIN_FAILED, AlertMessages.WRONG_CREDENTIALS, AlertType.ERROR);
			else
				goToNewAppointmentScene(e);
		}
		else
			AlertMessages.createAlertWindow(AlertMessages.LOGIN_FAILED, AlertMessages.EMPTY_LOGIN_FIELDS, AlertType.ERROR);	
	}
	
	private boolean areFieldsFilled(String aUsername, String aPassword)
	{
		return !aUsername.isEmpty() && !aPassword.isEmpty();
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
	
	
	public void changeToSignUpScene(ActionEvent e) throws IOException
	{
		Node node = (Node) e.getSource(); //get the source of the event
		
		if(node.equals(signUpButton))
		{
			root = FXMLLoader.load(this.getClass().getResource("../scenes/SignUpScene.fxml"));
			scene = new Scene(root, 600, 600);
			scene.getStylesheets().add(this.getClass().getResource("../css/signUp.css").toExternalForm());
			
			stage = (Stage) node.getScene().getWindow(); //get the stage of the node
			stage.setScene(scene);
			stage.show();
		}
		
		
	}
}
