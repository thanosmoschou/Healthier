/*
 * Author: Thanos Moschou
 * Description: This is a doctor appointment app written in Java by
 * using JavaFX.
 * Last Modification Date: 10/12/2023
 */

package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


/*
 * application folder is the root folder for the project
 */

public class Main extends Application 
{
	@Override
	public void start(Stage primaryStage) 
	{
		try 
		{
			//testing purposes only
			//AutoLoginForDebugging debug = new AutoLoginForDebugging();
			//debug.login(primaryStage);
			
			Parent root = FXMLLoader.load(this.getClass().getResource("scenes/LoginScene.fxml"));
			Scene scene = new Scene(root, 600, 600);
			scene.getStylesheets().add(this.getClass().getResource("css/login.css").toExternalForm());
			
			primaryStage.setScene(scene);
			primaryStage.setTitle("Health!er");
			primaryStage.setResizable(false);
			primaryStage.show();
			
		} 
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) 
	{
		launch(args);
	}
}
