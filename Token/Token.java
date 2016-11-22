package Token;

//done
public class Token
{
	protected String string_text;
	
	public Token(String text_token)
	{
		string_text = text_token;
	}

	/*
	public static Token create(String text)
	{
		if(MDParser.checkToken(text)=="PlainText")
		{
			return new PlainText(text);
		}
		
		else if(MDParser.checkToken(text)=="Escape")
		{
			return new Escape(text);
		}
		
		else if(MDParser.checkToken(text)=="SpecialChar")
		{
			return new SpecialChar(text);
		}
		
		else if(MDParser.checkToken(text)=="Emp")
		{
			return new Emp(text);
		}
		
		else if(MDParser.checkToken(text)=="HtmlCode")
		{
			return new HtmlCode(text);
		}
		else if(MDParser.checkToken(text)=="Code")
		{
			return new Code(text);
		}
		else if(MDParser.checkToken(text)=="Auto")
		{
			return new Auto(text);
		}
		else if(MDParser.checkToken(text)=="Inline")
		{
			return new Inline(text);
		}
		else if(MDParser.checkToken(text)=="Ref")
		{
			return new Ref(text);
		}
		else if(MDParser.checkToken(text)=="Implicit")
		{
			return new Implicit(text);
		}
		else
			return new Token(text);
	}
	*/
	
	public String generate()
	{
		return string_text;
	}
	

}

