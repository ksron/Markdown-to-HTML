package Node;

import util.Lines;

class Code_Block extends Block{
	
	public Code_Block(Lines lines)
	{
		super(lines, "<pre><code>", "</code></pre>");
		
		String str;
		while((str = lines.next()) != null)
			str = str.replaceFirst("[ ]{4}", "");
		
		tokenize(lines);
	}
}
