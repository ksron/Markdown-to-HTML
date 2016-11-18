
public class Code_Block extends Block{

	// ********* Tokens[] token_list; *********
	
	public Code_Block(String input_str)
	{
		super(input_str);
		
		// ********* Tokenizing Process?? *********
	}
	
	public String generate()
	{
		String ret_str="<pre><code>";
		/*
		for(int i=0; i<token_list.length();i++)
		{
			ret_str+=token_list[i].generate();
		}
		*/
		return ret_str+"</code></pre>";
	}
}
