package Node;

import Token.TokenComponent;
import util.Lines;

class Block extends Node{

	public Block(Lines lines)
	{
		super(lines);
	}

	public Block(Lines lines, String start, String end) {
		super(lines, start, end);
	}	
	
	@Override
	public void add(TokenComponent token){
		throw new UnsupportedOperationException();
	}
}
