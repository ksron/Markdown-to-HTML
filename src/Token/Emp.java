package Token;

public class Emp extends StyleText
{
	private String emp;
	
	public Emp() {
		this("em");
	}
	
	public Emp(String text_token) {
		super(text_token);
		
		emp = "<em>";
	}
	
	public String generate()
	{
		return emp;
	}
}

