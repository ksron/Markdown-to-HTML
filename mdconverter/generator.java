package mdconverter;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.w3c.tidy.Tidy;

/*
 This is generator for visiting
 The implementation of FANCY will be implemented later.
 */
public class generator implements MDElementVisitor{

	private	String a;
	private String b;


	public void visit(Document doc){
		a = "<!DOCTYPE html PUBLIC \"-//IETF//DTD HTML 2.0//EN\">";
		a += "<head><title> MDConverter </title></head>";
		a += "<html>\n"+"<body>\n"+doc.generate()+"</body>\n"+"</html>";//Generator
		b= doc.getOutputFile();//Output file's directory & name & type

		validateHTML(a);
			try{
				FileWriter w_file = new FileWriter(b);

				//System.out.println("\n" + a);
				w_file.write(a);
				w_file.close();

			}catch(IOException e){
				e.printStackTrace();
			}
	}

	public void visit(MDConstruct md){

	}
	
	//This is for fancy visit.
	public void visit_fancy(Document doc){
		a = "<!DOCTYPE html PUBLIC \"-//IETF//DTD HTML 2.0//EN\">";
		a += "<head><title> MDConverter </title></head>"
				+ "<link rel = 'stylesheet' type = 'text/css' href = 'lib/fancy.css'/>";
		a += "<html>\n"+"<body>\n"+doc.generate()+"<p>Fancy Version</p>"+"</body>\n"+"</html>";//Generator
		b= doc.getOutputFile();//Output file's directory & name & type

		validateHTML(a);
			try{
				FileWriter w_file = new FileWriter(b);

				//System.out.println("\n" + a);
				w_file.write(a);
				w_file.close();

			}catch(IOException e){
				e.printStackTrace();
			}
	}

	
	private void validateHTML(String s){
		InputStream in = new ByteArrayInputStream(s.getBytes(StandardCharsets.UTF_8));

		Tidy tidy = new Tidy();
		tidy.setForceOutput(true);

		//ignore output
		tidy.parse(in, new ByteArrayOutputStream());
		tidy.setQuiet(true);

		System.out.println("\nerrors "+tidy.getParseErrors());
	    System.out.println("warnings "+tidy.getParseWarnings());
	}
}