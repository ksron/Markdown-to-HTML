class Emp_close extends StyleText
{
	private String emp_close;
	
	public Emp_close(String text_token) {
		super(text_token);
		
		if((text_token.contains("*")&&!text_token.contains("**"))||text_token.contains("_")&&!text_token.contains("__"))
		{
			emp_close = "</em>";
		}
		
		else if(text_token.contains("**")||text_token.contains("__"))
		{
			emp_close = "</strong>";
		}
	}
	
	public String generate()
	{
		return emp_close;
	}
}

