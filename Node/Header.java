
public class Header extends Node{
	
	protected String text;
	protected int size;

	public Header(String input_str)
	{
		super(input_str);
		
		if(input_str.contains("#") || input_str.contains("="))
		{
			text=input_str.replaceAll("#|=", "");
			token_array=Node.tokenize(text);
			size=1;
		}
		
		else if(input_str.contains("##") || input_str.contains("-"))
		{
			text=input_str.replaceAll("#|-", "");
			token_array=Node.tokenize(text);
			size=2;
		}
		
		else if(input_str.contains("###"))
		{
			text=input_str.replaceAll("#", "");
			token_array=Node.tokenize(text);
			size=3;
		}
		
		else if(input_str.contains("####"))
		{
			text=input_str.replaceAll("#", "");
			token_array=Node.tokenize(text);
			size=4;
		}
		
		else if(input_str.contains("#####"))
		{
			text=input_str.replaceAll("#", "");
			token_array=Node.tokenize(text);
			size=5;
		}
		
		else if(input_str.contains("######"))
		{
			text=input_str.replaceAll("#", "");
			token_array=Node.tokenize(text);
			size=6;
		}
	}

	public String generate()
	{
		String ret_str;
		for(int i=0; i<token_array.size();i++)
		{
			ret_str+=token_array.get(i).generate();
		}
		return "<h"+size+">"+ret_str+"<h"+size+">";
	}
	
}
