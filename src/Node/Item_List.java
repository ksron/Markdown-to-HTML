package Node;

import java.util.*;
import java.util.regex.Pattern;

import Token.TokenComponent;
import Token.Tokenizer;
import util.Lines;

abstract class Item_List extends Node{
	
	protected int num_elem=0;
	protected ArrayList<ArrayList<TokenComponent>> item_array=new ArrayList<ArrayList<TokenComponent>>();
	
	public Item_List(Lines lines)
	{	
		super(lines);
		
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
				Tokenizer tokenizer=new Tokenizer();
				item_array.add(tokenizer.tokenize(new_lines));
			}
			else
			{
				temp=lines.lineAt(i).replaceFirst("([0-9]|[+]|[*]|-)[.]?( )+", "");
				item_array.add(getTokenize(temp));
				i++;
			}
		}
	}

	public Item_List(Lines lines, String start, String end) {
		this(lines);
		setTag(start, end);
	}	
}
