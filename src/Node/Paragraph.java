package Node;

import Token.TokenComponent;
import util.Lines;

class Paragraph extends Block{
		
	public Paragraph(Lines lines)
	{		
		super(lines, "<p>", "</p>");
		for(int i = 0; i < lines.getLineNum(); i++){
			String s = lines.lineAt(i);
			lines.setLine(i,s.replaceAll("(\\t|[ ]{2,})\\n$", "<br />\n"));
		}

		tokenize(lines);
	}
	
	@Override
	public void add(TokenComponent token){
		throw new UnsupportedOperationException();
	}
}
