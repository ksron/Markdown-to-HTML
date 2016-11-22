package Token;

public class Links extends Token
{
	protected int i1, i2, j1, j2;
	public Links(String text_token) {
		super(text_token);
		
		i1 = text_token.indexOf("[");
		i2 = text_token.indexOf("]");
		
		j1 = text_token.indexOf("(");
		j2 = text_token.indexOf(")");
	}
	
}
