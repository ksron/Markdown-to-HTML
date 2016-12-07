package Token;


public class Inline_Img extends Image{

	private String path_text;
	private String title;
	
	public Inline_Img(String text_token)
	{
		super(text_token);
		String img_info=text_token.substring(text_token.indexOf("(")+1,text_token.indexOf(")"));
		String img_info_list[]=null;
		
		if(img_info.contains("\"")){
			img_info_list= img_info.split("\"");}
		else if(img_info.contains("'")){
			img_info_list = img_info.split("'");}
		else
			img_info_list = img_info.split("::::");
		
		if(img_info_list[0]!=null)
		{
			path_text=img_info_list[0].replace("\\","/").trim();
		}
		
		if(img_info_list.length==2)
		{
			title=img_info_list[1].substring(0, img_info_list[1].length()).trim();
			string_text = "<img src=\""+path_text+"\" alt=\""+alt_text+ "\" title=\""+title+ "\"/>";
		}
		else 
			string_text = "<img src=\""+path_text+"\" alt=\""+alt_text+"\"/>";
	}		
}
