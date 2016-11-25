package Node;

import Token.TokenComponent;
import util.Lines;

class Hr extends Node{
	
	public Hr(Lines lines)
	{
		super(lines);
	}
	
	public String generate()
	{
		return new String("<hr>");
	}
	
	@Override
	public void add(TokenComponent token){
		throw new UnsupportedOperationException();
	}
}
