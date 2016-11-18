import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileNotFoundException;

public class generator implements MDElementVisitor{
	
	public void visit(Node node){
		node.getString();
		try{
		FileWriter m_writer = new FileWriter("test.html",true);
		m_writer.write("<h1>"+node.getString()+"</h1>"+"<hr/>"+"\n");
		m_writer.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		
		System.out.println(node.getString());
		
		}
	public void visit(Token token){
		token.getString();
		try{
			FileWriter m_writer = new FileWriter("test.html",true);
			m_writer.write("<marquee>" + "<p>" + "<font color = 'cyun'>" 
							+token.getString()+"</font></p>"+"</marquee>"+"\n");
			m_writer.close();
		}catch(IOException e){
				e.printStackTrace();
			}
		System.out.println(token.getString());
		}
	public void visit(MDConstruct md){}
}
