//done

class Emp extends StyleText
{
	protected String emp_text;
	
	public Emp(String text_token) {
		super(text_token);
		
		if(text_token.contains("*")&&!text_token.contains("**"))
		{
			emp_text = "<em>"+text_token.replaceAll("*", "")+"</em>";
		}
		
		else if(text_token.contains("_")&&!text_token.contains("__"))
		{
			emp_text = "<em>"+text_token.replaceAll("_", "")+"</em>";
		}

		else if(text_token.contains("**"))
		{
			emp_text = "<strong>"+text_token.replaceAll("**", "")+"</strong>";
		}
		
		if(text_token.contains("__"))
		{
			emp_text = "<strong>"+text_token.replaceAll("__", "")+"</strong>";
		}
	}
	
	public String generate()
	{
		return emp_text;
	}
}

