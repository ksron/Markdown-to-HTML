
public class Paragraph extends Block{
	
	Tokens[] token_list;
	int token_num=0;
	
	public Paragraph(String input_str)
	{		
		super(input_str);
	
		int i=0;
		for(i=0; i<input_str.length();i++)
		{
			if(input_str.charAt(i)=='*')
			{
				if(input_str.charAt(i+1)=='*')
				{
					token_list[token_num++]=new Emp(input_str.substring(i,input_str.indexOf("*", i+2)+2));
					i++;
					break;
				}
				else
				{
					token_list[token_num++]=new Emp(input_str.substring(i,input_str.indexOf("*", i+1)+1));
					break;
				}
			}	
			else if(input_str.charAt(i)=='_')
			{
				if(input_str.charAt(i+1)=='_')
				{
					token_list[token_num++]=new Emp(input_str.substring(i,input_str.indexOf("_", i+2)+2));
					i++;
					break;
				}
				else
				{
					token_list[token_num++]=new Emp(input_str.substring(i,input_str.indexOf("_", i+1)+1));
					break;
				}
			}	
			else if(input_str.charAt(i)==92)
			{
				token_list[token_num++]=new Escape(input_str.substring(i,i+2));
				i++;
			}
			else if((input_str.charAt(i)=='<') || (input_str.charAt(i)=='&'))
			{
				token_list[token_num++]=new SpecialChar(input_str.substring(i,i+2));
			}
			else if(input_str.charAt(i)==96)
			{
				token_list[token_num++]=new Code(input_str.substring(i+1,input_str.indexOf("'", i+1)));
				i+=(input_str.substring(i+1,input_str.indexOf("'", i+1))).length();
			}
			else if(input_str.charAt(i)=='[')
			{
				if(input_str.substring(i).contains("(") && input_str.substring(i).contains(")"))
				{
					token_list[token_num++]=new Inline(input_str.substring(i,input_str.indexOf(")")+1));
					i+=(input_str.substring(i,input_str.indexOf(")"+1))).length()-1;
				}
				else if(input_str.substring(i).contains("[]"))
				{
					int index=input_str.indexOf("[", i+1);
					index=input_str.indexOf("]", index+1);
					token_list[token_num++]=new Implicit(input_str.substring(i,index+1));
					i+=(input_str.substring(i,input_str.indexOf(")"+1))).length()-1;
				}
				else
				{
					int index=input_str.indexOf("[", i+1);
					index=input_str.indexOf("]", index+1);
					token_list[token_num++]=new Ref(input_str.substring(i,index+1));
					i+=(input_str.substring(i,input_str.indexOf(")"+1))).length()-1;
				}
			}
		}
	}

	public String generate()
	{
		String ret_str="";
		
		int i=0;
		for(i=0; i<token_list.length();i++)
		{
			ret_str+=token_list[i].generate();
		}
		
		return ret_str;
	}
}
