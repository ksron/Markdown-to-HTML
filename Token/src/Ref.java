import java.util.ArrayList;

//developing

class Ref extends Links
{
	ArrayList<String> link_text = new ArrayList<String>();
	ArrayList<String> link_label = new ArrayList<String>();
	ArrayList<Integer> refNum = new ArrayList<Integer>();
	
	ArrayList<String> link_title = new ArrayList<String>();
	ArrayList<String> link_url = new ArrayList<String>();
	ArrayList<Integer> labelNum = new ArrayList<Integer>();
	
	String tempUrl;
	
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
		int i1 = reference.indexOf("[");
		int i2 = reference.indexOf("]");
		
		int j1 = reference.lastIndexOf("[");
		int j2 = reference.lastIndexOf("]");
		
		link_text.add(reference.substring(i1+1, i2));	
		link_label.add(reference.substring(j1, j2+1)); //ex. link_label = [id]
	}
	
	public String LinkLabel(String defLinkLabel)
	{
		String[] spLinkLabel;

		//when the link has a title
		if(defLinkLabel.contains("\""))
		{
			spLinkLabel = defLinkLabel.split("\"");
			tempUrl = spLinkLabel[0];
			link_title.add(spLinkLabel[1]);
		}
		
		else if(defLinkLabel.contains("`"))
		{
			spLinkLabel = defLinkLabel.split("`");
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
		}
		
		
		
		//get Link_url
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

	}
	
	//Todo
	public String generate()
	{
		
		//To Be Modified
		return string_text;
	}
}