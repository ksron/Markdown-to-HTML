package mdconverter;

import java.util.Iterator;
import java.util.LinkedList;

import Token.TokenComponent;

public class Document implements MDElement{
	private String input_file;
	private String format;
	private String output_file;
	private String output_dir;
	private String style;
	public String converter;

	protected LinkedList<TokenComponent> nodes;


	public Document(){

	}

	public Document(Option options){
		this.input_file = options.get("i");
		this.output_file = options.get("o");
		this.format = options.get("f");
		this.style = options.get("s");
		this.output_dir = options.get("d");
		nodes = new LinkedList<TokenComponent>();
	}

	public void updateNode(TokenComponent node){
		this.nodes.add(node);
	}

	public LinkedList<TokenComponent> getNodes(){
		return this.nodes;
	}

	public String generate(){
		String s ="";

		Iterator<TokenComponent> it = nodes.iterator();
		while(it.hasNext()){
			s += it.next().generate() + "\n";
		}

		return s;
	}

	//getter
	public String getInputFile() {
		return input_file;
	}
	
	public String getOutputFile() {
		return output_dir + "\\" + output_file + "." + format;
	}

	public String getStyle() {
		return style;
	}

	public void accept(MDElementVisitor md){
		md.visit(this);
	}

}
