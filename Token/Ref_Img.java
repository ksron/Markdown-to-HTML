
public class Ref_Img extends Image{
	
	protected String id;
	
	public Ref_Img(String input_str)
	{
		super(input_str);
		
		id=input_str.substring(input_str.lastIndexOf("[")+1, input_str.lastIndexOf("]"));
	}
	
	public String generate()
	{
		Link_Addr temp;
		
		for(int i=0; i<Node.link_array.size();i++)
		{
			if(id==Node.link_array.get(i).id)
			{
				temp=Node.link_array.get(i);
				break;
			}
		}
		
		if(temp.title!=null)
		{
			return "<a href="+"><img src="+temp.path_text+" alt="+alt_text+"/>" + temp.title + "</a>";
		}
		else
		{
			return "<img src="+temp.path_text+" alt="+alt_text+"/>";	
		}
	}

}
