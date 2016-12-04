package Token;

import Node.Link_Addr;

public class Ref_Img extends Image{
	
	private String id;
	
	public Ref_Img(String text_token)
	{
		super(text_token);
		id=text_token.substring(text_token.lastIndexOf("[")+1, text_token.lastIndexOf("]"));
	}
	
	public String generate()
	{
		Link_Addr link_addr = new Link_Addr(null);
		
		link_addr.setProperties(id);
		
		if(link_addr.getPath_text()==null)//no reference for the ID
		{
			return string_text;
		}
		else
		{
			if(link_addr.getTitle()!="")
				return "<img src=\""+link_addr.getPath_text()+"\" alt=\""+alt_text+ "\" title=\""+link_addr.getTitle()+ "\" />";
			else
				return "<img src=\""+link_addr.getPath_text()+"\" alt=\""+alt_text+"\"/>";
		}
	}

}
