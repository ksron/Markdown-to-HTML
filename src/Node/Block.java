package Node;

import Token.TokenComponent;
import util.Lines;

class Block extends Node{

	public Block(Lines lines)
	{
		super();
	}

	public Block(String start, String end) {
		super(start, end);
	}	
	
	@Override
	public void add(TokenComponent token){
		throw new UnsupportedOperationException();
	}
}
