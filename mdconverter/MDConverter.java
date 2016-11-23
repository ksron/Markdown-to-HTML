package mdconverter;

import java.util.Iterator;

import Node.Node;

public class MDConverter {
	public static void main(String[] args) {
		Option options = new Option(args);
		
		Document doc = new Document(options);
				
		MDParser parser = new MDParser();
		parser.parse(doc);
		
		Iterator<Node> it = doc.getNodes().iterator();
		while(it.hasNext()){
			System.out.println(it.next().generate());
		}
		
	}
}
