package application;


public class Doctor extends User
{
	private String ssn;
	
	
	public Doctor(String aUsername, String aPassword, String anEmail, String anSSN, String aPhone)
	{
		super(aUsername, aPassword, anEmail, aPhone);
		this.ssn = anSSN;
	}
	
	public String getSSN()
	{
		return ssn;
	}
	
}
