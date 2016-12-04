package Node;

import util.Lines;

class Code_Block extends Block{
	
	public Code_Block(Lines lines)
	{
		super(lines, "<pre><code>", "</code></pre>");

		for(int i = 0; i < lines.getLineNum(); i++){
			lines.setLine(i, lines.lineAt(i).replaceFirst("([ ]{4}|\t)", ""));
		}
		
		tokenize(lines.toString());
	}
}
