/*
 * Author: Thanos Moschou
 * Description: This is a doctor appointment app written in Java by
 * using JavaFX.
 * Last Modification Date: 8/12/2023
 */

package application;

import java.util.regex.Pattern;

public class Validator 
{
	/*
	 * PROBLEM CODES:
	 * 1 = Invalid First name
	 * 2 = Invalid Last name
	 * 3 = Invalid Username
	 * 4 = invalid Password
	 * 5 = invalid Email
	 * 6 = invalid SSN
	 * 7 = invalid Phone number
	 * 8 = invalid Date
	 */
	
	private static int problemCode = -1;
	
	//If something is valid then problemCode will not be used
	public static boolean isFirstNameValid(String firstName)
	{
		problemCode = 1;
		return !firstName.isEmpty();
	}
	
	public static boolean isLastNameValid(String lastName)
	{
		problemCode = 2;
		return !lastName.isEmpty();
	}
	
	public static boolean isUsernameValid(String username)
	{
		problemCode = 3;
		return !username.isEmpty();
	}
	
	public static boolean isPasswordValid(String password)
	{
		/*
		 * (?=.*[0-9]) this means that I want any character (specified by the .) multiple times (specified by
		 * the *) and these characters to belong in my class. This means that I want at least one digit
		 * 
		 * .{8,} means that I want any character 8 or more times. 
		 */
		
		problemCode = 4;
		return Pattern.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*()])(?!.* ).{8,}$", password);
	}
	
	public static boolean isEmailValid(String email)
	{
		//I want emails that have at least one character from a-z or A-Z or 0-9
		//then have @ symbol, at least one character from the same ranges as before,
		//a single . character and after the . symbol 2 or 3 letters.
		
		problemCode = 5;
		return Pattern.matches("[a-zA-Z0-9.-]+@[a-zA-Z0-9]+[.]{1}[a-z]{2,3}", email);
	}
	
	public static boolean isSSNValid(String ssn)
	{
		//ssn is 5 numbers long for simplicity
		
		problemCode = 6;
		return ssn.matches("[0-9]{5}");
	}
	
	public static boolean isPhoneValid(String phone)
	{
		//phone is a 10 digit number (I do not care about countries)
		
		problemCode = 7;
		return phone.matches("[0-9]{10}");
	}
	
	//Format: year-month-day
	public static boolean isDateValid(String date)
	{
		problemCode = 8;
		return Pattern.matches("\\d{4}-\\d{1,2}-\\d{1,2}", date);
	}
	
	public static int getProblemCode()
	{
		return problemCode;
	}
}
