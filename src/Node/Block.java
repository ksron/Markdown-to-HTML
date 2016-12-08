package Node;

import util.Lines;

public abstract class Block extends Node{

	public Block(Lines lines)
	{
		super();
	}

	public Block(String start, String end) {
		super(start, end);
	}
}
