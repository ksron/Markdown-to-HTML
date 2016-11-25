package Node;

import util.Lines;

class Unord_List extends Item_List{
	
	public Unord_List(Lines lines)
	{
		super(lines, "<ul>", "</ul>");
	}
	
	public String generate()
	{
		String ret_str="";
		
		for(int i=0; i<item_array.size();i++)
		{
			String temp="";
			
			for(int j=0; j<item_array.get(i).size();j++)
			{
				temp+=item_array.get(i).get(j).generate();
			}
			ret_str+="<li>"+temp+"</li>";
		}
		
		return startingTag + ret_str + endingTag;
	}
}
