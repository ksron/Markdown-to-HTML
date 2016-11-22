
public class Inline_Img extends Image{

	protected String path_text;
	protected String title;
	
	public Inline_Img(String input_str)
	{
		super(input_str);
		String img_info=input_str.substring(input_str.indexOf("(")+1);
		String img_info_list[]=img_info.split(" ");
		
		if(img_info_list[0]!=null)
		{
			path_text=img_info_list[0];
		}
		
		if(img_info_list[1]!=null)
		{
			title=img_info_list[1].substring(1, img_info_list[1].length()-2);
		}
	}	
	
	public String generate()
	{
		if(title!=null)
		{
			return "<a href="+"><img src="+path_text+" alt="+alt_text+"/>" + title + "</a>";
		}
		else
		{
			return "<img src="+path_text+" alt="+alt_text+"/>";	
		}
	}
	
}
