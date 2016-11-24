package mdconverter;

//Visitor for Node & Token
public interface MDElementVisitor{

	public void visit(Node_practice node);
	public void visit(Token_practice token);
	public void visit(MDConstruct mdConstruct);
	public void visit(Document doc);
	public void visit(Mconvert con);
	
	/*
	-------------Node Case-------------
	public void visit(Inline_Img image);
	public void visit(Ref_Img Ref);
	public void visit(Link_Addr Link);
	public void visit(Hr hr);
	public void visit(Header header);
	public void visit(HTML_Block block);
	public void visit(Paragraph paragraph);
	public void visit(Quoted_Block qb);
	public void visit(Unord_List UL);
	public void visit(Ord_List OL);
	*/

	/*
	----------Token Case-------------
	public void visit(PlainText PT);
	public void visit(Escape escaple);
	public void visit(SpecialChar SC);
	public void visit(Emp emp);
	public void visit(HtmlCode HC);
	public void visit(Code cd);
	public void visit(Auto at);
	public void visit(Inline il);
	public void visit(Ref rf);
	public void visit(Implicit it);
	*/
}
