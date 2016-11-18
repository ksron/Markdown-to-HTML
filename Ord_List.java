
public class Ord_List extends Item_List{
	
	public Ord_List(String input_str)
	{
		super(input_str);
	}

	public String generate()
	{
		String ret_str="<ol>";
		
		for(int i=0; i<num_elem;i++)
		{
			ret_str+="<li>"+items[i]+"<li>";
		}
		
		return ret_str+"</ol>";
	}
}
