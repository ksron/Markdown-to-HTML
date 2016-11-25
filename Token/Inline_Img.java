package Token;


public class Inline_Img extends Image{

	protected String path_text;
	protected String title;
	
	public Inline_Img(String input_str)
	{
		super(input_str);
		String img_info=input_str.substring(input_str.indexOf("(")+1,input_str.indexOf(")"));
		String img_info_list[]=img_info.split("\"");
		
		if(img_info_list[0]!=null)
		{
			path_text=img_info_list[0];
		}
		
		if(img_info_list.length==2)
		{
			title=img_info_list[1].substring(0, img_info_list[1].length());
		}
	}	
	
	public String generate()
	{
		if(title!=null)
		{
			return "<img src=\""+path_text+"\" alt=\""+alt_text+ "\" title=\""+title+ "\" />";
		}

		else
		{
			return "<img src=\""+path_text+"\" alt=\""+alt_text+"\"/>";
		}
	}
	
}
