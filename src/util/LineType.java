package util;

public enum LineType {
	CODE("(\\t|[ ]{4})(.*)"),
	QUOTED("[ ]{0,3}>[ ]*(.*)"),
	UNORDERED("[ ]{0,3}[*+-][ ]+(.)*"),
	ORDERED("[ ]{0,3}\\d+\\.[ ]*(.*)"),
	ATX_HEADER("[ ]{0,3}(#+[ ]+)(.*)"),
	BAR_LINE("[ ]{0,3}([-]+\\s*){3,}\\s*"),
	SETEXT_HEADER("[ ]{0,3}([=]+\\s*){3,}\\s*"),
	HR("^[ ]{0,3}([*|-]+\\s*){3,}\\s*$"),
	LINKADDR("[ ]{0,3}\\[(\\w|\\d)*\\]:[ |\\t]*(.*)([ ][\\\"|\\\'|\\(](.*)[\\\"|\\\'|\\)])?\\s*"),
	EMPTY("^\\s*$"),
	BLOCK("^.*");
	
	public final String pattern;

    private LineType(String pattern) {
      this.pattern = pattern;
    }
    
    static public LineType getLineType(String line){
		if(line == null){
			return LineType.EMPTY;
		}
		else if(line.matches(LineType.CODE.pattern)){
			return LineType.CODE;
		}
		else if(line.matches(LineType.QUOTED.pattern)){
			return LineType.QUOTED;
		}
		else if(line.matches(LineType.HR.pattern)){
			return LineType.HR;
		}
		else if(line.matches(LineType.UNORDERED.pattern)){
			return LineType.UNORDERED;
		}
		else if(line.matches(LineType.ORDERED.pattern)){
			return LineType.ORDERED;
		}
		else if(line.matches(LineType.ATX_HEADER.pattern)){
			return LineType.ATX_HEADER;
		}
		else if(line.matches(LineType.SETEXT_HEADER.pattern)){
			return LineType.SETEXT_HEADER;
		}
		else if(line.matches(LineType.BAR_LINE.pattern)){
			return LineType.BAR_LINE;
		}
		else if(line.matches(LineType.LINKADDR.pattern)){
			return LineType.LINKADDR;
		}
		else if(line.matches(LineType.EMPTY.pattern)){
			return LineType.EMPTY;
		}
		else if(line.matches(LineType.BLOCK.pattern)){
			return LineType.BLOCK;
		}
		else{
			return LineType.EMPTY;
		}
	}
}
