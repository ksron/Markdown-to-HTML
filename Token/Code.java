class Code extends Token
{
	public Code(String text_token) {
		super(text_token);
	}
	
	public String generate()
	{	
		return "<code>";
	}
}