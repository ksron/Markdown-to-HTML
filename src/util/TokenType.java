package util;

public enum TokenType {
	CODE("^([ ]\\'[ ])(.)+?([ ]\\'[ ])"),
	ESCAPE("^\\\\[\\\\'\\*\\_\\{\\}\\[\\]\\(\\)\\#\\.\\!]"),
	STRONG("^[\\_|\\*]{2}(.)+?[\\_|\\*]{2}"),
	EMP("^[\\_|\\*]{1}(.)+?[\\_|\\*]{1}"),
	INLINE_IMAGE("^\\!\\[(.)+?\\]\\((.)+?\\)"),
	REF_IMAGE("^\\!\\[(.)+?\\]\\[[\\d\\w\\s]+\\]"),
	INLINE("^\\[(.)+?\\]\\((.)+?\\)"),
	IMPLICIT("^\\[(.)+?\\]\\[\\]"),
	REF("^\\[(.)+?\\]\\[(.)+?\\]"),
	AUTO("^\\<((http)\\:((\\w\\d[\\-\\_])\\/)+\\/?)|(\\w\\d[\\-\\_])\\@(\\w\\d[\\-\\_\\.])\\>"),
	HTML("^\\<(.)+?\\>"),
	COPY("^&copy;"),
	SPECIAL("^[\\&\\<]"),
	NULL("^(\\t|\\r|\\n|\\v|\\f)"),
	PLAIN("^.");
	
	public final String pattern;

    private TokenType(String pattern) {
      this.pattern = pattern;
    }
}
