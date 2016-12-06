package Node;

import java.util.*;

import util.Lines;
import util.NodeType;
import Token.*;

public abstract class Node implements TokenComponent{

	protected String html;
	protected String startingTag;
	protected String endingTag;
	protected Tokenizer tokenizer = new Tokenizer();
	protected ArrayList<TokenComponent> tokens = new ArrayList<TokenComponent>();
	
	@Override
	public void add(TokenComponent token){
		tokens.add(token);
	}
	
	public TokenComponent getChild(int i){
		return (TokenComponent)tokens.get(i);
	}
	
	public Node(){
		this.html = "";
		this.setTag("", "");
	}

	public Node(String start, String end){
		this();
		this.setTag(start, end);
	}
	
	public void setTag(String start, String end){
		startingTag = start;
		endingTag = end;
	}
	
	public ArrayList<TokenComponent> getTokenize(String s){
		Tokenizer tokenizer=new Tokenizer();
		return tokenizer.tokenize(s);
	}
	
	public ArrayList<TokenComponent> getTokenize(Lines lines){
		Tokenizer tokenizer=new Tokenizer();
		return tokenizer.tokenize(lines);
	}
	
	public void tokenize(Lines lines){
		tokens = tokenizer.tokenize(lines);
	}
	
	public void tokenize(String lines){
		tokens = tokenizer.tokenize(lines);
	}
	
	public String generate()
	{
		for(int i = 0; i < tokens.size(); i++)
		{
			html+=tokens.get(i).generate();
		}
		
		html = html.trim();
		
		return startingTag+html+endingTag + "\n";
	}
	
	//Creating using Factory Method pattern
	public static Node create(Lines lines)
	{
		NodeType nodeType = lines.getLinesType();

		switch(nodeType){
			case CODE:
				return new Code_Block(lines);
			case LINKADDR:
				return new Link_Addr(lines);
			case HR:
				return new Hr(lines);
			case HEADER:
				return new Header(lines);
			case BLOCK:
				return new Paragraph(lines);
			case QUOTED:
				return new Quoted_Block(lines);
			case UNORDERED_LIST:
				return new Unord_List(lines);
			case ORDERED_LIST:
				return new Ord_List(lines);
			default:
					return null;
		}			
	}
	
}
