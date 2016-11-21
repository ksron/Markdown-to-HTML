import java.lang.*;
import java.util.*;

public class Node {

	protected String raw_data;
	public static ArrayList<Link_Addr> link_array = new ArrayList<Link_Addr>();
	public ArrayList<Token> token_array=new ArrayList<Token>();
	
	public Node(String input_str)
	{
		raw_data=input_str;
	}
	
	public static Node create(String input_str)
	{
		if(MDParser.checkNode(input_str)=="Link_Addr")
		{
			Link_Addr node=new Link_Addr(input_str);
			Node.link_array.add(node);
			return node;
		}
		if(MDParser.checkNode(input_str)=="Hr")
		{
			return new Hr(input_str);
		}
		if(MDParser.checkNode(input_str)=="Header")
		{
			return new Header(input_str);
		}
		if(MDParser.checkNode(input_str)=="HTML_Block")
		{
			return new HTML_Block(input_str);
		}
		
		if(MDParser.checkNode(input_str)=="Paragraph")
		{
			return new Paragraph(input_str);
		}
		
		if(MDParser.checkNode(input_str)=="Code_Block")
		{
			return new Code_Block(input_str);
		}
		
		if(MDParser.checkNode(input_str)=="Quoted_Block")
		{
			return new Quoted_Block(input_str);
		}
		
		if(MDParser.checkNode(input_str)=="Unord_List")
		{
			return new Unord_List(input_str);
		}
		
		if(MDParser.checkNode(input_str)=="Ord_List")
		{
			return new Ord_List(input_str);
		}
		
		return new Node(input_str);
	}
	
	public static ArrayList<Token> tokenize(String input_str)
	{
		int i=0;
		String temp="";
		ArrayList<Token> token_list=new ArrayList<Token>(); 
		
		for(i=0; i<input_str.length();i++)
		{
			if(input_str.charAt(i)=='*')
			{
				token_list.add(new PlainText(temp));
				temp="";
				
				int emp_count=0;
				for(int j=0; j<token_list.size();j++)
				{
					if((token_list[j] instanceof Emp) || (token_list[j] instanceof Emp_Close))
						emp_count++;
				}
				if(input_str.charAt(i+1)=='*')
				{
					if(emp_count%2==0)
						token_list.add(new Emp(input_str.substring(i,i+2)));
					else
						token_list.add(new Emp_Close(input_str.substring(i, i+2)));
					i++;
				}
				else
				{
					if(emp_count%2==0)
						token_list.add(new Emp(input_str.substring(i,i+1)));
					else
						token_list.add(new Emp_Close(input_str.substring(i, i+1)));
				}
			}	
			else if(input_str.charAt(i)=='_')
			{
				token_list.add(new PlainText(temp));
				temp="";
				
				int emp_count=0;
				for(int j=0; j<token_list.size();j++)
				{
					if((token_list[j] instanceof Emp) || (token_list[j] instanceof Emp_Close))
						emp_count++;
				}
				if(input_str.charAt(i+1)=='_')
				{
					if(emp_count%2==0)
						token_list.add(new Emp(input_str.substring(i,i+2)));
					else
						token_list.add(new Emp_Close(input_str.substring(i, i+2)));
					i++;
				}
				else
				{
					if(emp_count%2==0)
						token_list.add(new Emp(input_str.substring(i,i+1)));
					else
						token_list.add(new Emp_Close(input_str.substring(i, i+1)));
				}
			}	
			else if(input_str.charAt(i)==92)
			{
				token_list.add(new PlainText(temp));
				temp="";
				
				token_list.add(new Escape(input_str.substring(i,i+2)));
				i++;
			}
			else if(input_str.charAt(i)==96)
			{
				token_list.add(new PlainText(temp));
				temp="";
				
				int code_count=0;
				for(int j=0; j<token_list.size();j++)
				{
					if((token_list[j] instanceof Code) || (token_list[j] instanceof Code_Close))
						code_count++;
				}

				if(code_count%2==0)
					token_list.add(new Code(input_str.substring(i,i+1)));
				else
					token_list.add(new Code_Close(input_str.substring(i, i+1)));
			}
			else if((input_str.charAt(i)=='!') && (input_str.charAt(i+1)=='['))
			{					
				int index=input_str.indexOf("]",i);
				
				if(input_str.charAt(index+1)=='(')
				{
					token_list.add(new PlainText(temp));
					temp="";
					
					token_list.add(new Inline_Img(input_str.substring(i,input_str.indexOf(")",index)+1)));
					i+=input_str.substring(i,input_str.indexOf(")",index)+1).length()-1;
				}
				else if(input_str.charAt(index+1)=='[')
				{
					token_list.add(new PlainText(temp));
					temp="";
					
					token_list.add(new Inline_Img(input_str.substring(i,input_str.indexOf("]",index+1)+1)));
					i+=input_str.substring(i,input_str.indexOf("]",index+1)+1).length()-1;
				}
				else
				{
					temp=temp+input_str.charAt(i);
				}
			}
			else if(input_str.charAt(i)=='[')
			{
				token_list.add(new PlainText(temp));
				temp="";
				
				if(input_str.substring(i).contains("(") && input_str.substring(i).contains(")"))
				{
					token_list.add(new Inline(input_str.substring(i,input_str.indexOf(")",i+1)+1)));
					i+=(input_str.substring(i,input_str.indexOf(")",i+1)+1)).length()-1;
				}
				else if(input_str.substring(i).contains("[]"))
				{
					int index=input_str.indexOf("[", i+1);
					index=input_str.indexOf("]", index);
					token_list.add(new Implicit(input_str.substring(i,index+1)));
					i+=(input_str.substring(i,index+1)).length()-1;
				}
				else
				{
					int index=input_str.indexOf("[", i+1);
					index=input_str.indexOf("]", index);
					token_list.add(new Ref(input_str.substring(i,index+1)));
					i+=(input_str.substring(i,index+1)).length()-1;
				}
			}
			else if(input_str.charAt(i)=='&')
			{
				token_list.add(new PlainText(temp));
				temp="";
				
				token_list.add(new SpecialChar(input_str.substring(i,i+1)));
			}
			else if(input_str.charAt(i)=='<')
			{
				token_list.add(new PlainText(temp));
				temp="";
				
				if(!input_str.substring(i).contains(">"))
				{
					token_list.add(new SpecialChar(input_str.substring(i,i+1)));
				}
				else
				{
					int index=input_str.indexOf(">",i);
					if((input_str.substring(i, index+1)).contains("."))
					{
						token_list.add(new Auto(input_str.substring(i,index+1)));
						i+=(input_str.substring(i,index+1)).length()-1;
					}
					else
					{
						index=input_str.indexOf(">",index+1);
						token_list.add(new HtmlCode(input_str.substring(i,index+1)));
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
			token_list.add(new PlainText(temp));
		
		return token_list;
	}

	public String generate()
	{
		return raw_data;
	}
}
