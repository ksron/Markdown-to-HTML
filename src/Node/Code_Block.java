package Node;

import util.Lines;

public class Code_Block extends Block{

	Lines codeLines = new Lines();

	public Code_Block(Lines lines)
	{
		super("<pre><code>", "</code></pre>");

		for(int i = 0; i < lines.getLineNum(); i++){
			lines.setLine(i, lines.lineAt(i).replaceFirst("([ ]{4}|\t)", ""));
			lines.setLine(i, lines.lineAt(i).replaceAll("&", "&amp;"));
			lines.setLine(i, lines.lineAt(i).replaceAll("<", "&lt;"));
			lines.setLine(i, lines.lineAt(i).replaceAll(">", "&gt;"));
		}

		codeLines = lines;
	}

	public String generate()
	{
		for(int i = 0; i < codeLines.getLineNum(); i++)
		{
			html += codeLines.lineAt(i);
		}

		html = html.trim();

		return startingTag+html+endingTag + "\n";
	}
}
