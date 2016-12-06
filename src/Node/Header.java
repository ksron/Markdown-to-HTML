package Node;

import util.Lines;

class Header extends Node{
	
	protected String text;
	protected int size;

	public Header(Lines lines)
	{
		super();
		
		lines.setLine(0, lines.lineAt(0).replaceFirst("\\s{0,3}", ""));
		if(lines.lineAt(0).charAt(0) == '#'){
			size = 1;
			
			for(int i = 1; i < lines.lineAt(0).length(); i++){
				if(lines.lineAt(0).charAt(i) != '#')
					break;
				size++;
			}
			
			lines.setLine(0, lines.lineAt(0).substring(size));
			
			if(size > 6) 
				size = 6;
		}
		else if(lines.getLineNum() > 1){
			if(lines.lineAt(1).contains("="))
				size = 1;
			else if(lines.lineAt(1).contains("-"))
				size = 2;
			
			lines.removeLast();	
		}
		else{
			size = 6;
		}

		setTag("<h"+size+">", "</h"+size+">");
		tokenize(lines.toString());
	}
}
