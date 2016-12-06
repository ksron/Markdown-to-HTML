package Node;

import util.Lines;
import java.util.*;

class Ord_List extends Item_List{
	
	public Ord_List(Lines lines)
	{
		super(lines, "<ol>", "</ol>");
	}

	public String generate()
	{
		String temp="";
		String ret_str = "";
		ArrayList<String> str_list=new ArrayList<String>();
		
		for(int i=0; i<item_array.size();i++)
		{	
			temp="";
			for(int j=0; j<item_array.get(i).size();j++)
			{
				temp+=item_array.get(i).get(j).generate();
			}
			str_list.add(temp);
		}
		temp="";
		for(int i=0; i<str_list.size()-1;i++)
		{
			if(str_list.get(i).contains("<ol>")|| str_list.get(i).contains("<ul>"))
			{
				ret_str+="<li>"+temp+str_list.get(i)+"</li>";
				temp="";
			}
			else
			{
				if(i<str_list.size()-1 && str_list.get(i+1).contains("<ol>"))
					temp+=str_list.get(i);
				else
					ret_str+="<li>"+str_list.get(i)+"</li>";
			}
		}
		return startingTag + ret_str + endingTag;
	}
}
