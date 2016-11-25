package Node;

import java.util.*;

import Token.TokenComponent;
import util.Lines;

abstract class Item_List extends Node{
	
	protected int num_elem=0;
	protected ArrayList<ArrayList<TokenComponent>> item_array=null;
	
	public Item_List(Lines lines)
	{
		super(lines);
		String temp="";
		String trim_input=lines.toString().trim();
		
		for(int i=0;i<trim_input.length();i++)
		{
			if(('0'<=trim_input.charAt(i)) && (trim_input.charAt(i)<='9'))
			{
				trim_input.replace(trim_input.charAt(i), '*');
				trim_input.replace(trim_input.charAt(i+1), ' ');
				i++;
			}
		}
		
		for(int i=1;i<trim_input.length();i++)
		{
			if((trim_input.charAt(i)=='*')||(trim_input.charAt(i)=='+')||(trim_input.charAt(i)=='-'))
			{
				//tokenize(line);
				item_array.add(tokens);
				temp="";
			}
			else
			{
				temp+=trim_input.charAt(i);
			}
		}
	}

	public Item_List(Lines lines, String start, String end) {
		this(lines);
		setTag(start, end);
	}	
}
