package application;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class AlertMessages 
{
	private static Alert alert;
	
	public static final String LOGIN_FAILED = "Login Failed";
	public static final String EMPTY_LOGIN_FIELDS = "Please fill the fields in order to login.";
	public static final String WRONG_CREDENTIALS = "Credentials are wrong. Try again.";
	public static final String REGISTRATION_FAILED = "Registration Failed";
	public static final String EMPTY_USERNAME_ALERT = "Username cannot be empty.";
	public static final String INVALID_PASSWORD_ALERT = "Password must be at least 8 digits long and"
														+ "containing at least\none lowercase, one uppercase, one number, and one of "
														+ "the\nfollowing special characters: "
														+ "!@#$%^&*()";
	public static final String INVALID_EMAIL_ALERT = "Please enter a valid email.";
	public static final String INVALID_SSN_ALERT = "Please enter a valid SSN number.";
	public static final String INVALID_PHONE_ALERT = "Please enter a valid phone number.";
	public static final String SOMETHING_WENT_WRONG = "Something went wrong and user cannot be created.\nTry again later.";
	public static final String APPOINTMENT_BOOKING_FAILED = "Booking Failed";
	public static final String EMPTY_FIRSTNAME_ALERT = "First name cannot be empty.";
	public static final String EMPTY_LASTNAME_ALERT = "Last name cannot be empty";
	public static final String EMPTY_DATE_ALERT = "Please select a date";
	public static final String CANNOT_PRINT_LIST = "List cannot be printed";
	public static final String REGISTRATION_SUCCESS = "Registration succeed";
	public static final String REGISTRATION_SUCCESS_MESSAGE = "Doctor is now registered!";
	public static final String DOCTOR_ALREADY_EXISTS = "Doctor is already registered in the app (the ssn you provided is reserved).";
	public static final String APPOINTMENT_BOOKING_SUCCESS = "Successful booking";
	public static final String APPOINTMENT_BOOKING_SUCCESS_MESSAGE = "The booking was successful.";
	public static final String APPOINTMENT_BOOKING_FAILED_MESSAGE = "Something went wrong and booking could not be stored.\nTry again later.";
	public static final String EMPTY_APPOINTMENT_FIELDS_MESSAGE = "Please fill the fields.";
	
	public static void createAlertWindow(String title, String content, AlertType type)
	{
		alert = new Alert(type);
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.setContentText(content);
		alert.show();
	}
}
