
public class Link_Addr extends Node{

	public String id;
	public String path_text;
	public String title;
	
	public Link_Addr(String input_str)
	{
		super(input_str);
		
		id=input_str.substring(input_str.indexOf("[")+1,input_str.indexOf("]"));
		
		String[] img_info_list=input_str.split(" ");
		
		path_text=img_info_list[1];
		
		if(img_info_list[2]!=null)
			title=img_info_list[2].substring(1, img_info_list[2].length()-1);
	}
}
