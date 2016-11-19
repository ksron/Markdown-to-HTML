//done
class Auto extends Links
{
	protected String address;
	
	public Auto(String text_token) {
		super(text_token);
		
		if(text_token.contains("<")&&text_token.contains(">"))
		{
			address = text_token.replace("<", "");
			address = text_token.replace(">", "");			
		}
		
		if(address.contains("@"))
		{
			address = "<a href=\"mailto:"+address+"\">"+address+"</a>";
		}
		else //address of a webpage
		{
			address = "<a href=\""+address+"\">"+address+"</a>";
		}
	}
	
	public String generate()
	{
		return address;
	}
}