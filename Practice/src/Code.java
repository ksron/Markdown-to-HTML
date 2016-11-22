package mdconverter;

//done
class Code extends Token
{
	public Code(String text_token) {
		super(text_token);
	}
	
	public String generate()
	{
		String html_token="";
		
		html_token="<code>"+string_text+"</code>"; 
		return html_token;
	}
}