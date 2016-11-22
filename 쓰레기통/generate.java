import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileNotFoundException;

public class generate{

	public static void main(String[] args){

	System.out.println("Call Generator\n");
		//Call Generator

	}

}

//Generator: String -> HTML Code
public class generator implements MDElementVisitor{

	MDElementVisitor[] visitors;

	public void visitNode(Node node){
		System.out.println(node.node1);
		}
	public void visitToken(Token token){
		System.out.println(token.token1);
		}
	public generator(){
		this.visitors = new MDElementVisitor[]{
			new Node(), new Token()};
		}
	public void accept(MDElementVisitor visitor){
				visitor.visitNode(this);
				visitor.visitToken(this);
		}

}


//Visitor for Node & Token
public interface MDElementVisitor{

	public void visitNode(Node node);
	public void visitToken(Token token);

}

//Element
public interface MDElement{
	public void accept(MDElementVisitor mdelementVisitor);
}

//Node / Token is String maker.

public class Node implements MDElement{

	public void Node(){

		String node1 = "Node Practice";

		}


	public void accept(MDElementVisitor mdelementVisitor){
		mdelementVisitor.visitNode(this);
		}



}