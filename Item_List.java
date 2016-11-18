
public class Item_List extends Node{
	
	protected String[] items;
	protected int num_elem=0;
	
	public Item_List(String input_str)
	{
		super(input_str);
		String temp="";
		String trim_input=input_str.trim();
		
		for(int i=0;i<trim_input.length();i++)
		{
			if((0<trim_input.charAt(i)) && (trim_input.charAt(i)<9))
			{
				trim_input.replace(trim_input.charAt(i), '*');
			}
		}
		
		for(int i=0;i<trim_input.length();i++)
		{
			if((trim_input.charAt(i)=='*')||(trim_input.charAt(i)=='+')||(trim_input.charAt(i)=='-'))
			{
				items[num_elem]=temp;
				temp="";
				num_elem++;
			}
			else
			{
				temp+=trim_input.charAt(i);
			}
		}
	}	
}
