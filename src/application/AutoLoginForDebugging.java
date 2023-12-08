/*
 * Author: Thanos Moschou
 * Description: This is a doctor appointment app written in Java by
 * using JavaFX.
 * Last Modification Date: 8/12/2023
 */

package application;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AutoLoginForDebugging 
{
	private static String username = "test1";
	private static String password = "aaAA11!!";
	
	public void login(Stage primaryStage)
	{
		//Doctor object is already initialized inside the fetchUserMethod by implementing Singleton Design Pattern
		Doctor doc = Db.fetchUserFromDb(username, password);
		
		try 
		{
			Parent root = FXMLLoader.load(this.getClass().getResource("scenes/MyAppointmentsScene.fxml"));
			Scene scene = new Scene(root, 860, 670);
			scene.getStylesheets().add(this.getClass().getResource("css/myAppointments.css").toExternalForm());
			
			primaryStage.setScene(scene);
			primaryStage.setTitle("Health!er");
			primaryStage.setResizable(false);
			primaryStage.show();
		} 
		catch(IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
