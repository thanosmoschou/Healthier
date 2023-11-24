package application;

public abstract class User 
{
	protected String username;
	protected String password;
	protected String email;
	protected String phone;
	
	public User(String aUsername, String aPassword, String anEmail, String aPhone)
	{
		this.username = aUsername;
		this.password = aPassword;
		this.email = anEmail;
		this.phone = aPhone;
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

	public String getPhone() 
	{
		return phone;
	}
	
	
}
