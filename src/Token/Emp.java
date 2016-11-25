package Token;

public class Emp extends StyleText
{
	private String emp;
	
	public Emp(String text_token) {
		super(text_token);
		
		if((text_token.contains("*")&&!text_token.contains("**"))||text_token.contains("_")&&!text_token.contains("__"))
		{
			emp = "<em>";
		}
		
		else if(text_token.contains("**")||text_token.contains("__"))
		{
			emp = "<strong>";
		}
		
	}
	
	public String generate()
	{
		return emp;
	}
}

