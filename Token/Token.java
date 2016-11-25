package Token;

//done
public abstract class Token implements TokenComponent{
	protected String string_text;
	
	public Token(String text_token)
	{
		string_text = text_token;
	}
	
	public String generate()
	{
		return string_text;
	}

	@Override
	public void add(TokenComponent token) {
		throw new UnsupportedOperationException();
	}
	

}

