package Node;

class Paragraph extends Block{
		
	public Paragraph(String input_str)
	{		
		super(input_str);
		token_array=Node.tokenize(input_str);
	}

	public String generate()
	{
		String ret_str="<p>";
		
		for(int i=0; i<token_array.size();i++)
		{
			ret_str+=token_array.get(i).generate();
		}
		
		return ret_str+"<p>";
	}
}
