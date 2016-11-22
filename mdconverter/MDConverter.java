package mdconverter;

public class MDConverter {
	public static void main(String[] args) {
		Option options = new Option(args);
		
		Document doc = new Document(options);
				
		MDParser parser = new MDParser();
		parser.parse(doc);
		
	}
}
