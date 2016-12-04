package Token;


public class Inline_Img extends Image{

	protected String path_text;
	protected String title;
	
	public Inline_Img(String input_str)
	{
		super(input_str);
		String img_info=input_str.substring(input_str.indexOf("(")+1);
		
		path_text = img_info.substring(0, img_info.indexOf(" "));
		
		int title_start = img_info.indexOf("\"")+1;
		if(title_start > 0){
			int title_end = title_start + img_info.substring(title_start).indexOf("\"");
			title = img_info.substring(title_start, title_end);
		}

	}	
	
	public String generate()
	{
		if(title!=null)
		{
			return "<img src="+path_text+" alt="+alt_text+" title=\"" + title + "\"/>";
		}
		else
		{
			return "<img src="+path_text+" alt="+alt_text+"/>";	
		}
	}
	
}
