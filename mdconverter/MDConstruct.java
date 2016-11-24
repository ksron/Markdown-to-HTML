package mdconverter;

import java.util.LinkedList;

import Node.Node;
/*
  얘는 MDConstruct.
 Visit 담아 두는 Construct 입니다.
 */

public class MDConstruct implements MDElement, Cloneable{
	int i=0;
	MDElement[] parts;
	LinkedList<Node> test = new LinkedList<Node>();
	
	public MDConstruct(){
		
	}
	public MDConstruct(Document document) {	
		// TODO Auto-generated constructor stub/
		parts = new MDElement[] {new Node_practice(), new Token_practice(), document, new Mconvert()};
	}
	
	/*
    public MDElement[] getElements() {
        return parts.clone(); // Return a copy of the array of references.
    }*/
	
	public void accept(MDElementVisitor md){
		for(i=0;i<parts.length;i++){
			parts[i].accept(md);
		}
	}
	
}