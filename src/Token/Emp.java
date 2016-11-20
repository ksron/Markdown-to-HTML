package Token;
//done

class Emp extends StyleText
{
	protected String emp_text;
	
	public Emp(String text_token) {
		super(text_token);
		
		if(text_token.contains("*")&&!text_token.contains("**"))
		{
			emp_text = "<em>"+text_token.replace("*", "")+"</em>";
		}
		
		else if(text_token.contains("_")&&!text_token.contains("__"))
		{
			emp_text = "<em>"+text_token.replace("_", "")+"</em>";
		}

		else if(text_token.contains("**"))
		{
			emp_text = "<strong>"+text_token.replace("**", "")+"</strong>";
		}
		
		if(text_token.contains("&gt;"))
		{
			emp_text = "<strong>"+text_token.replace("__", "")+"</strong>";
		}
	}
	
	public String generate()
	{
		return emp_text;
	}
}

