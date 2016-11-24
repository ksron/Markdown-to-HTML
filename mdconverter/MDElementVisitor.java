package mdconverter;

//Visitor for Node & Token
public interface MDElementVisitor{

	public void visit(MDConstruct mdConstruct);
	public void visit(Document doc);
	public void visit(Mconvert con);

}
