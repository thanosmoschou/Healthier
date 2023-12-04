package application;


//This class implements the Singleton Design Pattern
//I want only one instance of Doctor object while app is running
//If user logs out and then he logs in again, I change only the instances attributes
public class Doctor
{
	private String username;
	private String password;
	private String email;
	private String ssn;
	private String phone;
	private static Doctor instance = null;
	
	private Doctor()
	{
	}
	
	
	public static Doctor getInstance()
	{
		if(instance == null)
			instance = new Doctor();
		
		return instance;
	}
	
	
	public static void setDoctorsData(String aUsername, String aPassword, String anEmail, String anSSN, String aPhone)
	{
		instance.username = aUsername;
		instance.password = aPassword;
		instance.email = anEmail;
		instance.ssn = anSSN;
		instance.phone = aPhone;
	}


	public String getUsername()
	{
		return username;
	}


	public String getPassword()
	{
		return password;
	}


	public String getEmail() 
	{
		return email;
	}


	public String getSsn()
	{
		return ssn;
	}


	public String getPhone() 
	{
		return phone;
	}
	
	
	
	
}
