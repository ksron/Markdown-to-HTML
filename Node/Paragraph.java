package Node;

import Token.TokenComponent;
import util.Lines;

class Paragraph extends Block{
		
	public Paragraph(Lines lines)
	{		
		super(lines, "<p>", "</p>");
		tokenize(lines);
	}
	
	@Override
	public void add(TokenComponent token){
		throw new UnsupportedOperationException();
	}
}
