package Token;
//&lt, &gt; &amp
//developing -check Todo
class SpecialChar extends StyleText
{
	protected String spCh;
	public SpecialChar(String text_token) 
	{
		super(text_token);
		
		//Todo: Is using '&' itself in MD allowed?
		if(text_token.contains("&"))
		{
			spCh = text_token.replace("&", "&amp");
		}
		
		if(text_token.contains("&amp;"))
		{
			spCh = text_token;
		}

		if(text_token.contains("&lt;"))
		{
			spCh = text_token;
		}
		
		if(text_token.contains("&gt;"))
		{
			spCh = text_token;
		}
	}
	
	public String generate()
	{
		return spCh;
	}
}