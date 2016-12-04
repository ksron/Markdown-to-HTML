package Token;

public class Code_close extends Token
{
	public Code_close(String text_token) {
		super(text_token);
	}
	
	public Code_close() {
		this("");
	}

	public String generate()
	{	
		return "</code>";
	}
}