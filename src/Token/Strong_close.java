package Token;

public class Strong_close extends StyleText{
	private String emp_close;
	
	public Strong_close() {
		this("strong_close");
	}
	
	public Strong_close(String text_token) {
		super(text_token);
		
		emp_close = "</strong>";
	}
	
	public String generate()
	{
		return emp_close;
	}
	
}
