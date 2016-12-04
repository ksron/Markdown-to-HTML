package Token;
import Node.Link_Addr;

public class Implicit extends Links
{
	private String link_text;
	
	public Implicit(String text_token) {
		super(text_token);
		link_text=text_token.substring(i1+1, i2);
	}
	

	public String generate()
	{
        Link_Addr link_addr = new Link_Addr(null);
		
		link_addr.setProperties(link_text);
		
		if(link_addr.getPath_text()==null)//no reference for the ID
		{
			return string_text;
		}
		else
		{
			if(link_addr.getTitle()!="")
				return "<a href= \"" + link_addr.getPath_text() + "\" title = \""+link_addr.getTitle()+"\">"+link_text+"</a>";
			else
				return "<a href= \"" + link_addr.getPath_text() + "\">"+link_text+"</a>";
		}
	}
}




