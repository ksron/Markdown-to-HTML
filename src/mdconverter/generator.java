package mdconverter;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.w3c.tidy.Tidy;

/*
 얘가 진짜 쓰는 generator 입니다.
 visitor pattern으로 node나 token마다 다 방문해서
 String return 하는 프로그램이고, 다 html 위에 덮어 쓰는걸로 작업했습니다.
 */
public class generator implements MDElementVisitor{

//String filename = new option_input.filename();
	//얘는 나중에 CLI에서 input file 체크해서 method로 return 하는 거 받아서 받아 쓰려고 만들었습니다.
	private String b;
	private String c;
	private String d;
	
	public void visit(Document doc){
		String a;

		a = "<!DOCTYPE html PUBLIC \"-//IETF//DTD HTML 2.0//EN\">";
		a += "<head><title> MDConverter </title></head>";
		a += "<html>\n"+"<body>\n"+doc.generate()+"</body>\n"+"</html>";//Generator
		b= doc.getOutputFile();//Output file's name
		c= doc.getOutputDir();//Output File's direction
		d= doc.getFormat();//Output File's Style
		
		if(validateHTML(a))
			try{
				FileWriter w_file = new FileWriter(c+ "\\" +b+ "." +d);
				
				System.out.println("\n" + a);
				w_file.write(a);		
				w_file.close();
		
			}catch(IOException e){
				e.printStackTrace();
			}
		else 
			System.err.println("Not a valid HTML");
	}	
	
	public void visit(MDConstruct md){
		
	}

	private boolean validateHTML(String s){
		InputStream in = new ByteArrayInputStream(s.getBytes(StandardCharsets.UTF_8));
		
		Tidy tidy = new Tidy();
		tidy.setForceOutput(true);
		
		//ignore output
		tidy.parse(in, new ByteArrayOutputStream());
		tidy.setQuiet(true);
		
		System.out.println("\nerrors "+tidy.getParseErrors());
	    System.out.println("warnings "+tidy.getParseWarnings());
	   
	    return (tidy.getParseErrors() == 0 && tidy.getParseWarnings()-2 == 0);
	}
}