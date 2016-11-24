package Token;

import java.util.ArrayList;

public class Tokenizer {
	private ArrayList<TokenComponent> tokens;
	
	public Tokenizer(){
		tokens = new ArrayList<TokenComponent>();
	}

	public ArrayList<TokenComponent> tokenize(String input_str)
	{
		int i=0;
		String temp="";
		
		for(i=0; i<input_str.length();i++)
		{
			if(input_str.charAt(i)=='*')
			{
				tokens.add(new PlainText(temp));
				temp="";
				
				int emp_count=0;
				for(int j=0; j<tokens.size();j++)
				{
					if((tokens.get(j) instanceof Emp) || (tokens.get(j) instanceof Emp_close))
						emp_count++;
				}
				if(input_str.charAt(i+1)=='*')
				{
					if(emp_count%2==0)
						tokens.add(new Emp(input_str.substring(i,i+2)));
					else
						tokens.add(new Emp_close(input_str.substring(i, i+2)));
					i++;
				}
				else
				{
					if(emp_count%2==0)
						tokens.add(new Emp(input_str.substring(i,i+1)));
					else
						tokens.add(new Emp_close(input_str.substring(i, i+1)));
				}
			}	
			else if(input_str.charAt(i) == ('_'))
			{
				tokens.add(new PlainText(temp));
				temp="";
				
				int emp_count=0;
				for(int j=0; j<tokens.size();j++)
				{
					if((tokens.get(j) instanceof Emp) || (tokens.get(j) instanceof Emp_close))
						emp_count++;
				}
				if(input_str.charAt(i+1) == ('_'))
				{
					if(emp_count%2==0)
						tokens.add(new Emp(input_str.substring(i,i+2)));
					else
						tokens.add(new Emp_close(input_str.substring(i, i+2)));
					i++;
				}
				else
				{
					if(emp_count%2==0)
						tokens.add(new Emp(input_str.substring(i,i+1)));
					else
						tokens.add(new Emp_close(input_str.substring(i, i+1)));
				}
			}	
			else if(input_str.charAt(i)==92)
			{
				tokens.add(new PlainText(temp));
				temp="";
				
				tokens.add(new Escape(input_str.substring(i,i+2)));
				i++;
			}
			else if(input_str.charAt(i)==96)
			{
				tokens.add(new PlainText(temp));
				temp="";
				
				int code_count=0;
				for(int j=0; j<tokens.size();j++)
				{
					if((tokens.get(j) instanceof Code) || (tokens.get(j) instanceof Code_close))
						code_count++;
				}

				if(code_count%2==0)
					tokens.add(new Code(input_str.substring(i,i+1)));
				else
					tokens.add(new Code_close(input_str.substring(i, i+1)));
			}
			else if((input_str.charAt(i) == ('!')) && (input_str.charAt(i+1) == ('[')))
			{					
				int index=input_str.indexOf("]",i);
				
				if(input_str.charAt(index+1) == ('('))
				{
					tokens.add(new PlainText(temp));
					temp="";
					
					tokens.add(new Inline_Img(input_str.substring(i,input_str.indexOf(")",index)+1)));
					i+=input_str.substring(i,input_str.indexOf(")",index)+1).length()-1;
				}
				else if(input_str.charAt(index+1) == ('['))
				{
					tokens.add(new PlainText(temp));
					temp="";
					
					tokens.add(new Inline_Img(input_str.substring(i,input_str.indexOf("]",index+1)+1)));
					i+=input_str.substring(i,input_str.indexOf("]",index+1)+1).length()-1;
				}
				else
				{
					temp=temp+input_str.charAt(i);
				}
			}
			else if(input_str.charAt(i) == ('['))
			{
				tokens.add(new PlainText(temp));
				temp="";
				
				if(input_str.substring(i).contains("(") && input_str.substring(i).contains(")"))
				{
					tokens.add(new Inline(input_str.substring(i,input_str.indexOf(")",i+1)+1)));
					i+=(input_str.substring(i,input_str.indexOf(")",i+1)+1)).length()-1;
				}
				else if(input_str.substring(i).contains("[]"))
				{
					int index=input_str.indexOf("[", i+1);
					index=input_str.indexOf("]", index);
					tokens.add(new Implicit(input_str.substring(i,index+1)));
					i+=(input_str.substring(i,index+1)).length()-1;
				}
				else
				{
					int index=input_str.indexOf("[", i+1);
					index=input_str.indexOf("]", index);
					tokens.add(new Ref(input_str.substring(i,index+1)));
					i+=(input_str.substring(i,index+1)).length()-1;
				}
			}
			else if(input_str.charAt(i) == ('&'))
			{
				tokens.add(new PlainText(temp));
				temp="";
				
				tokens.add(new SpecialChar(input_str.substring(i,i+1)));
			}
			else if(input_str.charAt(i) == ('<'))
			{
				tokens.add(new PlainText(temp));
				temp="";
				
				if(!input_str.substring(i).contains(">"))
				{
					tokens.add(new SpecialChar(input_str.substring(i,i+1)));
				}
				else
				{
					int index=input_str.indexOf(">",i);
					if((input_str.substring(i, index+1)).contains("."))
					{
						tokens.add(new Auto(input_str.substring(i,index+1)));
						i+=(input_str.substring(i,index+1)).length()-1;
					}
					else
					{
						index=input_str.indexOf(">",index+1);
						tokens.add(new HtmlCode(input_str.substring(i,index+1)));
						i+=(input_str.substring(i,index+1)).length()-1;
					}
				}
			}
			else
			{
				temp=temp+input_str.charAt(i);
			}
		}
		if(temp!=null)
			tokens.add(new PlainText(temp));
		
		return tokens;
	}

}
