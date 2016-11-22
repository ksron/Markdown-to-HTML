package Token;

import mdconverter.MDParser;

//done
class Token
{
	protected String string_text;
	
	public Token(String text_token)
	{
		string_text = text_token;
	}
		
	private String checkToken(String text_token){
		String type = "";
		
		
		return type;
	}
	
	public Token create(String text_token)
	{
		if(checkToken(text_token)=="PlainText")
		{
			return new PlainText(text_token);
		}
		
		else if(checkToken(text_token)=="Escape")
		{
			return new Escape(text_token);
		}
		
		else if(checkToken(text_token)=="SpecialChar")
		{
			return new SpecialChar(text_token);
		}
		
		else if(checkToken(text_token)=="Emp")
		{
			return new Emp(text_token);
		}
		
		else if(checkToken(text_token)=="HtmlCode")
		{
			return new HtmlCode(text_token);
		}
		else if(checkToken(text_token)=="Code")
		{
			return new Code(text_token);
		}
		else if(checkToken(text_token)=="Auto")
		{
			return new Auto(text_token);
		}
		else if(checkToken(text_token)=="Inline")
		{
			return new Inline(text_token);
		}
		else if(checkToken(text_token)=="Ref")
		{
			return new Ref(text_token);
		}
		else if(checkToken(text_token)=="Implicit")
		{
			return new Implicit(text_token);
		}
		else
			return new Token(text_token);
	}
	
	public String generate()
	{
		return string_text;
	}
}

