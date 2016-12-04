package Token;

import Node.Link_Addr;

public class Ref extends Links
{
	private String link_text;
	private String link_label;

	public Ref(String text_token) {
		super(text_token);
		link_text=text_token.substring(i1+1, i2);	
		link_label=text_token.substring(j1+1, j2); //ex. link_label = [id]
	}
	

	public String generate()
	{
		Link_Addr link_addr = new Link_Addr(null);

		link_addr.setProperties(link_label);
		
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