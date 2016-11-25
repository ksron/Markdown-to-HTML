package Node;

import java.util.*;
import java.util.regex.Pattern;

import Token.TokenComponent;
import util.Lines;

abstract class Item_List extends Node{
	
	protected int num_elem=0;
	protected ArrayList<ArrayList<TokenComponent>> item_array=null;
	
	public Item_List(Lines lines)
	{
		super(lines);
		
		for(int i = 0; i < lines.getLineNum(); i++){
			String line = lines.lineAt(i);
			String s = null;
			
			if(Pattern.compile("^([ ]{0,3}([*+-]|[\\d+\\.])[ ])\\s{0,3}").matcher(line).find()){
				if(!s.equals(""))
					
				
				lines.setLine(i, s.replaceAll("^([ ]{0,3}([*+-]|[\\d+\\.])[ ])\\s{0,3}", ""));
				
				s += lines.lineAt(i);
				
				for(int j = i+1; j < lines.getLineNum(); j++){
					
				}
				
			}
			s = lines.lineAt(i);
			
			item_array.add(getTokenize(s));
		}
		

	}

	public Item_List(Lines lines, String start, String end) {
		this(lines);
		setTag(start, end);
	}	
}
