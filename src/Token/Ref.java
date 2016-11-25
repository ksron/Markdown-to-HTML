package Token;

import java.util.Iterator;
import java.util.LinkedList;

public class Ref extends Links
{
	private String link_text;
	private String link_label;
	
	protected LinkedList<String> link_title = new LinkedList<String>();
	protected LinkedList<String> link_url = new LinkedList<String>();
	protected LinkedList<String> key_label = new LinkedList<String>();
	
	private String tempUrl;
	
	public Ref(String text_token) {
		super(text_token);
		toHtml(text_token);
	}
	
	
	public void toHtml(String text_token) {
		if(text_token.contains(":"))
		{
			LinkLabel(text_token);
		}
		else
		{
			RefLink(text_token);
		}
	}
	
	public void RefLink(String reference)
	{	
		link_text=reference.substring(i1+1, i2);	
		link_label=reference.substring(j1, j2+1); //ex. link_label = [id]
	}
	
	public void LinkLabel(String defLinkLabel)
	{
		String[] spLinkLabel;

		//when the link has a title
		if(defLinkLabel.contains("\""))
		{
			spLinkLabel = defLinkLabel.split("\"");
			tempUrl = spLinkLabel[0];
			link_title.add(spLinkLabel[1]);
		}
		
		else if(defLinkLabel.contains("'"))
		{
			spLinkLabel = defLinkLabel.split("'");
			tempUrl = spLinkLabel[0];
			link_title.add(spLinkLabel[1]);
		}
		
		else if(defLinkLabel.contains("("))
		{
			spLinkLabel = defLinkLabel.split("(");
			tempUrl = spLinkLabel[0];
			link_title.add(spLinkLabel[1]);
		} 
		//when the link doesn't have a title
		else
		{
			tempUrl = defLinkLabel;
			link_title.add("");
		}
		
		
		//make Link_url
		if(tempUrl.contains("<"))
		{
			link_url.add(tempUrl.substring(tempUrl.indexOf("<")+1, tempUrl.indexOf(">")));
		}
		else if(tempUrl.contains("http"))
		{
			link_url.add(tempUrl.substring(tempUrl.indexOf("http"), tempUrl.length()));
		}
		else
		{
			//do nothing
			//there doesn't exit other case. IF it does, it doesn't follow markdown syntax. 
		}
		
		//make key_label
		key_label.add(tempUrl.substring(tempUrl.indexOf("[")+1, tempUrl.indexOf("]")));

	}
	
	public String generate()
	{
		if(string_text.contains(":"))
			return null;
		else
		{
			Iterator<String> iterator = key_label.iterator();
			int i = 0;
			
			while (iterator.hasNext())
			{
				String id = iterator.next();
				
				if(link_label.equals(id))
				{
					return "<a href= \"" + link_url.get(i) + "\" title = \""+link_title.get(i)+"\">"+link_text+"</a>";
				}
				
				i++;
			}
			return string_text; //when there's no URL for the label.
		}
	}
}