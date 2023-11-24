package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;



/*
 * application folder is the root folder of the project
 */

public class Main extends Application 
{
	@Override
	public void start(Stage primaryStage) 
	{
		try 
		{
			
			
			Parent root = FXMLLoader.load(this.getClass().getResource("scenes/LoginScene.fxml"));
			Scene scene = new Scene(root, 600, 600);
			scene.getStylesheets().add(this.getClass().getResource("css/login.css").toExternalForm());
			
			
			//Scene scene = new Scene(root, 600, 600);
			//scene.getStylesheets().add(this.getClass().getResource("signUp.css").toExternalForm());
			
			
			/*
			Parent root = FXMLLoader.load(this.getClass().getResource("scenes/MyAppointmentsScene.fxml"));
			Scene scene = new Scene(root, 860, 670);
			scene.getStylesheets().add(this.getClass().getResource("css/myAppointments.css").toExternalForm());
			*/
			
			/*
			Parent root = FXMLLoader.load(this.getClass().getResource("SignUpScene.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(this.getClass().getResource("signUp.css").toExternalForm());
			*/
			
			primaryStage.setScene(scene);
			primaryStage.setTitle("Health!er Login Page");
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
