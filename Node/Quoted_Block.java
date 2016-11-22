public class Quoted_Block extends Node{

	protected String text;

	public Quoted_Block(String input_str)
	{
		super(input_str);
		text=input_str;

		text.replaceAll(">", "");
		token_array=Node.tokenize(text);
	}

	public String generate()
	{
		String ret_str="<blockquote>";
		
		for(int i=0; i<token_array.size();i++)
		{
			ret_str+=token_array.get(i).generate();
		}
		
		return ret_str+"</blockquote>";
	}
	
}
