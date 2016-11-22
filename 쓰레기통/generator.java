public class generator implements MDElementVisitor{

	public void visitNode(Node node){
		System.out.println(node.node1);
		}
	public void visitToken(Token token){
		System.out.println(token.token1);
		}

}