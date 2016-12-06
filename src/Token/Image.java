package Token;

public class Image extends Token{

	protected String alt_text;
	
	public Image(String input_str)
	{
		super(input_str);
		alt_text=input_str.substring(input_str.indexOf("[")+1,input_str.indexOf("]"));
	}	
}
