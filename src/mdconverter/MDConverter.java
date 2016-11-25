package mdconverter;

public class MDConverter {
	public static void main(String[] args) {
		
		Option options = new Option(args);
		Document doc = new Document(options);		
		
		MDParser parser = new MDParser();
		MDElement c = new MDConstruct(doc);
		generator g = new generator();
		
		parser.parse(doc);		
		
		System.out.println("Call Generator\n");
			
		c.accept(g); //Visit Generator
	}
}
