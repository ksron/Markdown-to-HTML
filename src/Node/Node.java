package Node;
import mdconverter.Lines;
import mdconverter.NodeType;

public class Node {

	protected String raw_data;
	protected NodeType nodeType;
	
	public Node(){
		this("");
	}

	public Node(String input_str)
	{
		raw_data=input_str;
	}
	
	public NodeType getNodeType(){
		return this.nodeType;
	}
	
	public String toString(){
		return raw_data;
	}
	
	public static Node create(Lines lines)
	{
		NodeType nodeType = lines.getLinesType();
		String block = lines.toString();

		/*
		if(nodeType=="Inline_Image")
		{
			return new Inline_Img(input_str);
		}
		if(nodeType=="Ref_Image")
		{
			return new Ref_Img(block);
		}
		*/
		if(nodeType == NodeType.LINKADDR)
		{
			return new Link_Addr(block);
		}
		if(nodeType == NodeType.HR)
		{
			return new Hr(block);
		}
		if(nodeType == NodeType.HEADER)
		{
			return new Header(block);
		}
		/*
		if(nodeType=="HTML_Block")
		{
			return new HTML_Block(block);
		}
		*/
		if(nodeType == NodeType.BLOCK)
		{
			return new Paragraph(block);
		}
		
		if(nodeType == NodeType.QUOTED)
		{
			return new Quoted_Block(block);
		}
		
		if(nodeType == NodeType.UNORDERD_LIST)
		{
			return new Unord_List(block);
		}
		
		if(nodeType == NodeType.ORDERED_LIST)
		{
			return new Ord_List(block);
		}
		
		return new Node(block);
	}
	
	public String generate()
	{
		return raw_data;
	}
}
