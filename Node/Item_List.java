package Node;

import java.util.*;
import Token.Token;

class Item_List extends Node{
	
	protected int num_elem=0;
	protected ArrayList<ArrayList<Token>> item_array=null;
	
	public Item_List(String input_str)
	{
		super(input_str);
		String temp="";
		String trim_input=input_str.trim();
		
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
				ArrayList<Token> temp_array=Node.tokenize(temp);
				item_array.add(temp_array);
				temp="";
			}
			else
			{
				temp+=trim_input.charAt(i);
			}
		}
	}	
}
