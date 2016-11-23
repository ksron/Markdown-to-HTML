package Node;

import util.Lines;

class Quoted_Block extends Node{

	protected String text;

	public Quoted_Block(Lines lines)
	{
		super(lines, "<blockquote>", "</blockquote>");
		
		String str;
		while((str = lines.next()) != null)
			str = str.replaceFirst("[ ]{4}", "");
		
		tokenize(lines);
	}
	
}
