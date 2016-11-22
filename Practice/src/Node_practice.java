package mdconverter;

public class Node_practice implements MDElement{

	public String generate(){

		return "Node practice";

		}


	public void accept(MDElementVisitor mdelementVisitor){
		mdelementVisitor.visit(this);
		}



}