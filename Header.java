
public class Header extends Node{
	
	protected String text;
	protected int size;
	
	public Header(String input_str)
	{
		super(input_str);
		
		if(input_str.contains("#") || input_str.contains("==="))
		{
			text=input_str.replaceAll("#|=", "");
			size=1;
		}
		
		else if(input_str.contains("##") || input_str.contains("---"))
		{
			text=input_str.replaceAll("#|-", "");
			size=2;
		}
		
		else if(input_str.contains("###") || input_str.contains("---"))
		{
			text=input_str.replaceAll("#", "");
			size=3;
		}
		
		else if(input_str.contains("####") || input_str.contains("---"))
		{
			text=input_str.replaceAll("#", "");
			size=4;
		}
		
		else if(input_str.contains("#####") || input_str.contains("---"))
		{
			text=input_str.replaceAll("#", "");
			size=5;
		}
		
		else if(input_str.contains("######") || input_str.contains("---"))
		{
			text=input_str.replaceAll("#", "");
			size=6;
		}
	}

	public String generate()
	{
		return "<h"+size+">"+text+"<h"+size+">";
	}
	
}
