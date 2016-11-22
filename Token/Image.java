package Token;

import java.lang.*;

public class Image extends Token{

	protected String alt_text;
	
	public Image(String input_str)
	{
		super(input_str);
		alt_text=input_str.substring(input_str.indexOf("["),input_str.indexOf("]"));
	}	
}
