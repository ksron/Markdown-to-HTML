package Node;

import util.Lines;

class Quoted_Block extends Node{

	protected String text;

	public Quoted_Block(Lines lines)
	{
		super(lines, "<blockquote>", "</blockquote>");
		

		for(int i = 0; i < lines.getLineNum(); i++){
			lines.setLine(i, lines.lineAt(i).replaceFirst("^[ ]{0,3}>[ ]", ""));
		}

		tokenize(lines);
	}
	
}
