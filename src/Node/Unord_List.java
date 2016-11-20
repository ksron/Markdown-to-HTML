package Node;

public class Unord_List extends Item_List{
	
	public Unord_List(String input_str)
	{
		super(input_str);
	}
	
	public String generate()
	{
		String ret_str="<ul>";
		
		for(int i=0; i<num_elem;i++)
		{
			ret_str+="<li>"+items[i]+"<li>";
		}
		
		return ret_str+"</ul>";
	}
}
