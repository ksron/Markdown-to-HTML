import java.lang.*;

public class Node {

	protected String raw_data;
	
	public Node(String input_str)
	{
		raw_data=input_str;
	}
	
	public static Node create(String input_str)
	{
		if(MDParser.checkNode(input_str)=="Inline_Image")
		{
			return new Inline_Img(input_str);
		}
		if(MDParser.checkNode(input_str)=="Ref_Image")
		{
			return new Ref_Img(input_str);
		}
		if(MDParser.checkNode(input_str)=="Link_Addr")
		{
			return new Link_Addr(input_str);
		}
		if(MDParser.checkNode(input_str)=="Hr")
		{
			return new Hr(input_str);
		}
		if(MDParser.checkNode(input_str)=="Header")
		{
			return new Header(input_str);
		}
		if(MDParser.checkNode(input_str)=="HTML_Block")
		{
			return new HTML_Block(input_str);
		}
		
		if(MDParser.checkNode(input_str)=="Paragraph")
		{
			return new Paragraph(input_str);
		}
		
		if(MDParser.checkNode(input_str)=="Quoted_Block")
		{
			return new Quoted_Block(input_str);
		}
		
		if(MDParser.checkNode(input_str)=="Unord_List")
		{
			return new Unord_List(input_str);
		}
		
		if(MDParser.checkNode(input_str)=="Ord_List")
		{
			return new Ord_List(input_str);
		}
		
		return new Node(input_str);
	}
	
	public String generate()
	{
		return raw_data;
	}
}
