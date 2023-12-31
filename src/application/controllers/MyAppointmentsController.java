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
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class MyAppointmentsController 
{	
	@FXML
	private Button logoutButton;
	@FXML
	private ListView<String> history;
	@FXML
	private DatePicker dateField;
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	public void fillTheList()
	{
		String date = dateField.getValue().toString();
		
		if(Validator.isDateValid(date))
		{
			history.getItems().clear(); //clear the list view from previous searches
			ObservableList<String> appointments = Db.fetchAppointmentsFromDb(date);
			
			if(appointments != null && appointments.size() > 0)
			{
				history.getItems().add("First Name	Last Name	Email	Patient SSN    Phone");
				history.getItems().addAll(appointments);
			}
			else
				history.getItems().clear();	
		}
		else
			AlertMessages.createAlertWindow(AlertMessages.CANNOT_PRINT_LIST, AlertMessages.EMPTY_DATE_MESSAGE, AlertType.ERROR);
	}
	
	
	public void setDateToDateField()
	{
		if(dateField.getValue() == null)
			dateField.setValue(LocalDate.now());
	}
	
	
	public void changeToNewAppointmentScene(ActionEvent e)
	{
		Node node = (Node) e.getSource();
				
		try 
		{
			root = FXMLLoader.load(this.getClass().getResource("../scenes/NewAppointmentScene.fxml"));
			
			scene = new Scene(root, 860, 670);
			scene.getStylesheets().add(this.getClass().getResource("../css/newAppointment.css").toExternalForm());
			
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
