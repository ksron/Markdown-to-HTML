package Token;

public class Emp_close extends StyleText
{
	private String emp_close;
	
	public Emp_close() {
		this("em_close");
	}
	
	public Emp_close(String text_token) {
		super(text_token);
		
		emp_close = "</em>";
	}
	
	public String generate()
	{
		return emp_close;
	}
}

