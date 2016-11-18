
public class Ref_Img extends Image{
	
	protected String id;
	
	public Ref_Img(String input_str)
	{
		super(input_str);
		
		id=input_str.substring(input_str.lastIndexOf("["), input_str.lastIndexOf("]"));
	}
	
	public String generate()
	{
		Link_Addr temp=new Link_Addr("dummy"); 
		// ********* check the list of Link_Addr, find one with the same id value *********
		
		if(temp.title!=null)
		{
			return "<a href="+"> <img src="+temp.path_text+" alt="+alt_text+"/>" + temp.title + "</a>";
		}
		else
		{
			return "<img src="+temp.path_text+" alt="+alt_text+"/>";	
		}
	}

}
