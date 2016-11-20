package Node;

public class HTML_Block extends Block{

	public HTML_Block(String input_str)
	{
		super(input_str);
	}	
	
	public String generate()
	{
		return text;
	}
}
