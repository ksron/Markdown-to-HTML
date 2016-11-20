
public class Quoted_Block extends Node{

	protected String text;
	// ********* Tokens[] token_list; *********
	
	public Quoted_Block(String input_str)
	{
		super(input_str);
		text=input_str;
		
		// ********* Tokenizing Process?? *********
	}

	public String generate()
	{
		String ret_str="<blockquote>";
		/*
		for(int i=0; i<token_list.length();i++)
		{
			ret_str+=token_list[i].generate();
		}
		*/
		return ret_str+"</blockquote>";
	}
	
}
