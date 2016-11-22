
public class Code_Block extends Block{
	
	public Code_Block(String input_str)
	{
		super(input_str);
		token_array=Node.tokenize(input_str);
	}
	
	public String generate()
	{
		String ret_str="<pre><code>";
		
		for(int i=0; i<token_array.length();i++)
		{
			ret_str+=token_array.get(i).generate();
		}
		
		return ret_str+"</code></pre>";
	}
}
