package Node;

import Token.TokenComponent;
import util.Lines;

public class Link_Addr extends Node{

	public String id;
	public String path_text;
	public String title;
	
	public Link_Addr(Lines lines)
	{
		super(lines);
		
		id=lines.toString().substring(lines.toString().indexOf("[")+1,lines.toString().indexOf("]"));
		
		String[] img_info_list=lines.toString().split(" ");
		
		path_text=img_info_list[1];
		
		if(img_info_list.length == 3)
			title=img_info_list[2].substring(1, img_info_list[2].length()-1);
	}
	
	@Override
	public void add(TokenComponent token){
		throw new UnsupportedOperationException();
	}
	
	@Override
	public String generate(){
		return "";
	}
}
