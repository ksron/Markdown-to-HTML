package Token;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Node.Node;
import util.LineType;
import util.Lines;
import util.NodeType;
import util.TokenType;


public class Tokenizer {
	private ArrayList<TokenComponent> tokens;
	
	public Tokenizer(){
		tokens = new ArrayList<TokenComponent>();
	}

	public ArrayList<TokenComponent> tokenize(Lines lines){
		
		Iterator<String> it = lines.iterator();
		String s = it.next().replaceFirst("\\s+$", "");
		while(it.hasNext()){
			LineType type = LineType.getLineType(s);
			Lines newlines = new Lines();
			try{
				if(type == LineType.CODE){
					newlines.setLinesType(NodeType.CODE);
					while(type == LineType.CODE){
						newlines.append(s);
						s = it.next().replaceFirst("\\s+$", "");
						type = LineType.getLineType(s);
					}
				}
				else if(type == LineType.QUOTED ){
					newlines.setLinesType(NodeType.QUOTED);
					while(type == LineType.QUOTED  || type == LineType.BLOCK ){
						newlines.append(s);
						s = it.next().replaceFirst("\\s+$", "");
						type = LineType.getLineType(s);
					}
				}
				else if(type == LineType.UNORDERED ){
					newlines.setLinesType(NodeType.UNORDERED_LIST);
					while(type == LineType.UNORDERED  || type == LineType.EMPTY || type == LineType.CODE || type == LineType.BLOCK){
						newlines.append(s);
						s = it.next().replaceFirst("\\s+$", "");
						if(type == LineType.EMPTY){
							type = LineType.getLineType(s);
							if(type != LineType.CODE || type != LineType.UNORDERED )
								break;
						}
						else{
							type = LineType.getLineType(s);
						}
					}
				}
				else if(type == LineType.ORDERED ){
					newlines.setLinesType(NodeType.ORDERED_LIST);
					while(type == LineType.ORDERED  || type == LineType.EMPTY  || type == LineType.CODE){
						newlines.append(s);
						s = it.next().replaceFirst("\\s+$", "");
						type = LineType.getLineType(s);
					}
				}
				else if(type == LineType.ATX_HEADER ){
					newlines.setLinesType(NodeType.HEADER);
					newlines.append(s);
					s = it.next().replaceFirst("\\s+$", "");
				}
				else if(type == LineType.HR || type == LineType.BAR_LINE ){
					newlines.setLinesType(NodeType.HR);
					newlines.append(s);
					s = it.next().replaceFirst("\\s+$", "");
				}
				else if(type == LineType.LINKADDR ){
					newlines.setLinesType(NodeType.LINKADDR);
					newlines.append(s);
					s = it.next().replaceFirst("\\s+$", "");
				}
				else if(type == LineType.EMPTY ){
					newlines.setLinesType(NodeType.EMPTY);
					s = it.next().replaceFirst("\\s+$", "");
					continue;
				}
				else if(type == LineType.BLOCK || type == LineType.SETEXT_HEADER){
					newlines.setLinesType(NodeType.BLOCK);
					while(type == LineType.BLOCK || ((type == LineType.SETEXT_HEADER|| type == LineType.BAR_LINE)  && newlines.getLineNum() != 1)){
						newlines.append(s);
						s = it.next().replaceFirst("\\s+$", "");
						type = LineType.getLineType(s);
					}
					
					if((type == LineType.SETEXT_HEADER || type == LineType.BAR_LINE) && newlines.getLineNum() == 1){
						newlines.setLinesType(NodeType.HEADER);
						newlines.append(s);
						s = it.next().replaceFirst("\\s+$", "");
					}
				}
				else{
					tokenize(s);
					s = it.next().replaceFirst("\\s+$", "");;
					continue;
				}
			}catch (Exception e) {
				s = null;
				if(newlines.getLinesType() == NodeType.BLOCK)
					tokenize(newlines.toString());
				else 
					tokens.add(Node.create(newlines));
				continue;
			}
			
			if(newlines.getLinesType() == NodeType.BLOCK)
				this.tokenize(newlines.toString());
			else 
				tokens.add(Node.create(newlines));
		}
		

		return tokens;
	}
	 // FIXME ... Need fix
	public ArrayList<TokenComponent> tokenize(String input_str)
	{
		int i=0;
		String temp="";
		
		for(i=0; i<input_str.length();i++)
		{
			// EMP & STRONG
			String pattern[] = {"^([ ]\\'[ ])(.)+?([ ]\\'[ ])",
								"^\\\\[\\\\'\\*\\_\\{\\}\\[\\]\\(\\)\\#\\.\\!]",
								"^[\\_|\\*]{2}(.)+?[\\_|\\*]{2}", 
								"^[\\_|\\*]{1}(.)+?[\\_|\\*]{1}",
								"^\\!\\[(.)+?\\]\\((.)+?\\)",
								"^\\!\\[(.)+?\\]\\[[\\d\\w\\s]+\\]"
								};
			TokenType type[] = {TokenType.CODE, TokenType.ESCAPE, TokenType.STRONG, TokenType.EMP, 
								TokenType.INLINE_IMAGE, TokenType.REF_IMAGE};
			for(int patternNum = 0; patternNum < pattern.length; patternNum++){
				Pattern p = Pattern.compile(pattern[patternNum]);
				Matcher m = p.matcher(input_str.substring(i));
				if(m.find()){
					String out = m.group();
					tokens.add(new PlainText(temp));
					temp = "";
					
					switch(type[patternNum]){
					case CODE: 
						tokens.add(new Code());
						tokenize(out.substring(3, out.length()-3));
						tokens.add(new Code_close());
						break;
					case STRONG:
						tokens.add(new Strong());
						tokenize(out.substring(2, out.length()-2));
						tokens.add(new Strong_close());
						break;
					case EMP:
						tokens.add(new Emp());
						tokenize(out.substring(1, out.length()-1));
						tokens.add(new Emp_close());
						break;
					case ESCAPE:
						tokens.add(new Escape(out));
						break;
					case INLINE_IMAGE:
						tokens.add(new Inline_Img(out));
						break;
					case REF_IMAGE:
						tokens.add(new Ref_Img(out));
						break;
					default:
						break;
					}

					i = i + m.end();
	
				}
			}
			
			if(input_str.charAt(i) == ('['))
			{
				tokens.add(new PlainText(temp));
				temp="";
				
				// INLINE
				if(input_str.substring(i).contains("(") && input_str.substring(i).contains(")"))
				{
					tokens.add(new Inline(input_str.substring(i,input_str.indexOf(")",i+1)+1)));
					i+=(input_str.substring(i,input_str.indexOf(")",i+1)+1)).length()-1;
				}
				
				//IMPLICIT
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
			
			//SPECIAL CHAR
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
						//index=input_str.indexOf(">",index+1);
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
