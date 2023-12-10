## Health!er
It is time to make your patients healthier! <br>

### Screenshots
![Login](screenshots/login.png)
![Sign Up](screenshots/signup.png)
![New Appointment](screenshots/newAppointment.png)
![My Appointments](screenshots/myAppointments.png)

### How it works
Login to the app. <br>
If you do not have an account it is time to sign up! <br>
Fill the form with the patients credentials, select a date and click ```Schedule```. <br>
Now you are ready to accept your patient! <br>
If you want to view your patients for a specific day: <br>
Go to ```My Appointments``` section. Select a date and click ```Print List```. <br>

### Requirements before you run the app
You will need to do some things before you run the app for the first time. <br>
First, you need to set up the database. I used xampp package which has MySQL included. <br>
Xampp provide a default user with username ```root``` and it does not have a password. <br>

First, you will need to run the code in ```dbCreation.sql``` file in order to create the database.<br>
In real life, make sure you create a user different than ```root``` and give him a strong password.<br>
Next, you need Java installed on your PC. <br>
Also you need JavaFX (Download the JavaFX SDK from the original site). <br>

#### On Eclipse
Download e(fx)clipse plugin for Eclipse. <br>
Import the project. <br>
```
File -> Import -> General -> Projects from Folder or Archive -> Select the Directory button <br>
if you have a folder or select the Archive button if you have a zip file -> Finish <br>
```

First you need to create a user library: <br>
```
On the menu above select Window -> Preferences -> Java -> Build Path -> User Libraries -> New -> Enter a name -> Select the library you just created -> Add External JARs -> select the jars you want (we want the jar files that are included in the lib folder of javafx sdk) -> Apply and Close <br><br>
```

Add the JavaFX SDK as a library. <br>
```
Right click on project -> Build Path -> Add Libraries -> User Library -> Select the one you created for javafx -> Finish <br>
```

Now you need to type something more: 
```
Right click on the project -> Run As -> Run Configurations -> On the menu in the central part of the page select Arguments -> On the vm arguments section type: 
--module-path "path\to\javafx\lib" --add-modules javafx.controls,javafx.fxml <br>
```

Make sure you have changed ```path\to\javafx\lib``` to the original path of the javafx sdk lib folder. <br>
Finally press Apply and then Run. <br>

If you have an error while initializing boot layer:
```Right click on project -> Build Path -> Configure Build Path -> Java Build Path -> Check that javafx sdk that comes with e(fx)clipse is in classpath and not in module path. If it is in the module path, move it to the class path by drag and drop. <br><br>
```

The above steps are necessary only before you run the app for the first time. <br>
After you complete all the previous steps, you will be able to run the app whenever you want without having to set anything up. <br>

### Alternative ways to run the app
Open the runnableJar folder in a command line interface (Right click in the folder -> Open in Terminal. Then type the following command: <br>

```
java --module-path "path\to\javafx\lib" --add-modules javafx.controls,javafx.fxml -jar health!er.jar
```

Make sure you have changed ```path\to\javafx\lib``` to the original path of the javafx sdk lib folder. <br>

### Possible improvements
Add encryption to data. <br>
Make this app using a framework such as Spring. <br>

