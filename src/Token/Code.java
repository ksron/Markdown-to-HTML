package Token;

public class Code extends Token
{
	public Code(String text_token) {
		super(text_token);
	}
	
	public Code() {
		this("");
	}

	public String generate()
	{	
		return "<code>";
	}
}