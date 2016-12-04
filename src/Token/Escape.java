package Token;

public class Escape extends StyleText
{
	protected String esCh;
	
	
	public Escape(String text_token) 
	{
		super(text_token);
		String[] chList= {"`", "*", "_", "{", "}", "[", "]", "(", ")", "#", ".", "!"};
		
		for(int i=0; i<chList.length;i++)
		{
			if(text_token.contains("\\"+chList[i]))
			{
				esCh = chList[i];
				break;
			}
		}
	}
	
	public String generate()
	{
		return esCh;
	}
}