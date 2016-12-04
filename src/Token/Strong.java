package Token;

public class Strong extends StyleText{
	private String emp;

	public Strong() {
		this("strong");
	}
	
	public Strong(String text_token) {
		super(text_token);
		
		emp = "<strong>";
	}
	
	public String generate()
	{
		return emp;
	}
}
