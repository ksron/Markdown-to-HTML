public class MDConstruct implements MDElement{
	int i=0;
	MDElement[] parts;
	
	public MDConstruct() {
		// TODO Auto-generated constructor stub
		parts = new MDElement[] {new Node(), new Token()};
	}
	
	public void accept(MDElementVisitor md){
		for(i=0;i<parts.length;i++){
			parts[i].accept(md);
		}
	md.visit(this);
	}

}
