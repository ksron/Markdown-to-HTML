package Node;

import util.Lines;

public class Quoted_Block extends Node{

	protected String text;

	public Quoted_Block(Lines lines)
	{
		super("<blockquote>", "</blockquote>");


		for(int i = 0; i < lines.getLineNum(); i++){
			lines.setLine(i, lines.lineAt(i).replaceFirst("^[ ]{0,3}>[ ]", ""));
		}

		tokenize(lines);
	}

}
