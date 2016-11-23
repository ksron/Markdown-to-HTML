package util;

public enum LineType {
	CODE("[ ]{4}(.*)"),
	QUOTED("[ ]{0,3}>[ ]*(.*)"),
	UNORDERED("[ ]{0,3}[*+-][ ]*(^[*+-].)*"),
	ORDERED("[ ]{0,3}\\d+\\.[ ]*(.*)"),
	ATX_HEADER("[ ]{0,3}(#+[ ]+)(.*)"),
	BAR_LINE("[ ]{0,3}([-]+\\s*){3,}\\s*"),
	SETEXT_HEADER("[ ]{0,3}([=]+\\s*){3,}\\s*"),
	HR("[ ]{0,3}([*]+\\s*){3,}\\s*"),
	LINKADDR("[ ]{0,3}\\[(\\w|\\d)*\\]:[ ](.*)([ ]\\\"(.*)\\\")\\s*"),
	EMPTY("^\\s*$"),
	BLOCK("^.*");
	
	public final String pattern;

    private LineType(String pattern) {
      this.pattern = pattern;
    }
}
