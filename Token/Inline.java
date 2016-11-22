class Inline extends Links
{
	private String link;
	public Inline(String text_token) {
		super(text_token);
		
		String link_text = text_token.substring(i1+1, i2);
		
		//link_url is absolute pathname or relative pathname of an website or local resource
		String link_url = text_token.substring(j1+1, j2);
		
		if (link_url.contains("\""))
		{
			int k1 = text_token.indexOf("\"");
			int k2 = text_token.lastIndexOf("\"");
		    String title = text_token.substring(k1+1, k2);
		    link = "<a href= \"" + link_url + "\" title = \""+title+"\">"+link_text+"</a>";
		}

		link = "<a href= \"" + link_url + "\">"+link_text+"</a>";
	}
	
	public String generate()
	{
		return link;
	}
}