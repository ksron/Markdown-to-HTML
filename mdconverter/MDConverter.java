package mdconverter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

import Node.Node;

public class MDConverter {
	public static void main(String[] args) {
		String a;
		Option options = new Option(args);
		Document doc = new Document(options);		
		MDParser parser = new MDParser();
		MDElement c = new MDConstruct(doc);
		generator g = new generator();
		parser.parse(doc);		
		System.out.println("Call Generator\n");
		
	
		try{
			FileWriter w_file = new FileWriter("Practice.html");
			w_file.write("<html>\n");
			w_file.write("<body>\n");
			w_file.close();
			
			c.accept(g);
				
			FileWriter w_file2 = new FileWriter("Practice.html",true);
			w_file2.write("</body>\n");
			w_file2.write("</html>\n");
			w_file2.close();

			w_file.close();
		}catch(IOException e){
			e.printStackTrace();
		}

	}
}
