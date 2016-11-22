package mdconverter;

public enum LineType {
	CODE("(\\s{4}|\\t)(.*)"),
	QUOTED("(\\s{0,3}>\\s+)(.*)"),
	UNORDERED("\\s{0,3}[*+-]\\s(.*)"),
	ORDERED("\\s{0,3}\\d*\\.\\s+(.*)"),
	ATX_HEADER("(#+\\s+)(.*)"),
	SETEXT_HEADER("\\s{0,3}[[=|-]+\\s*]{3,}\\s*"),
	HR("\\s{0,3}((\\*{3,})|(-{3,}))\\s*"),
	LINKADDR("\\s{0,3}\\[(\\w|\\d)*\\]:\\s(.*)(\\s\\\"(.*)\\\")\\s*"),
	EMPTY("^\\s*$"),
	BLOCK("^.*");
	
	public final String pattern;

    private LineType(String pattern) {
      this.pattern = pattern;
    }
}
