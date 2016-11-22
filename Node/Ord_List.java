
public class Ord_List extends Item_List{
	
	public Ord_List(String input_str)
	{
		super(input_str);
	}

	public String generate()
	{
		String ret_str="<ol>";
		
		for(int i=0; i<item_array.size();i++)
		{
			String temp="";
			for(int j=0; j<item_array.get(i).size();j++)
			{
				temp+=item_array.get(i).get(j).generate();
			}
			ret_str+="<li>"+temp+"<li>";
		}
		
		return ret_str+"</ol>";
	}
}
