package Node;

import java.util.*;

import Token.TokenComponent;
import util.Lines;

public abstract class Item_List extends Node{

	protected int num_elem=0;
	protected ArrayList<ArrayList<TokenComponent>> item_array=new ArrayList<ArrayList<TokenComponent>>();

	public Item_List(Lines lines)
	{
		super();

		for(int i=0; i<lines.getLineNum();)
		{
			String temp="";
			if(lines.lineAt(i).charAt(0)==' ')
			{
				Lines new_lines=new Lines();
				while(lines.lineAt(i).charAt(0)==' ')
				{
					new_lines.append(lines.lineAt(i).replaceFirst("( )+", ""));
					i++;
				}

				item_array.add(getTokenize(new_lines));
			}
			else
			{
				temp=lines.lineAt(i).replaceFirst("([0-9]|[+]|[*]|-)[.]?( )+", "");
				if(temp.trim().length() > 0)
					item_array.add(getTokenize(temp));
				i++;
			}
		}
	}

	public Item_List(Lines lines, String start, String end) {
		this(lines);
		setTag(start, end);
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
		for(int i=0; i<str_list.size();i++)
		{
			if(str_list.get(i).contains("<ol>")|| str_list.get(i).contains("<ul>"))
			{
				ret_str+="<li>"+temp+str_list.get(i)+"</li>";
				temp="";
			}
			else
			{
				if(i<str_list.size()-1 && (str_list.get(i+1).contains("<ol>") || str_list.get(i+1).contains("<ul>")))
					temp+=str_list.get(i);
				else
					ret_str+="<li>"+str_list.get(i)+"</li>";
			}
		}
		return startingTag + ret_str + endingTag;
	}
}
