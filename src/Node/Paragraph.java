package Node;

import util.Lines;

public class Paragraph extends Block{

	public Paragraph(Lines lines)
	{
		super("<p>", "</p>");
		for(int i = 0; i < lines.getLineNum(); i++){
			String s = lines.lineAt(i);
			lines.setLine(i,s.replaceAll("(\\t|[ ]{2,})\\n$", "<br />\n"));
		}

		tokenize(lines.toString());
	}
}
