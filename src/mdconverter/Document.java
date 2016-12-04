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
		this.setInputFile(options.get("i"));
		this.setOutputFile(options.get("o"));
		this.setFormat(options.get("f"));
		this.setStyle(options.get("s"));
		this.setOutputDir(options.get("d"));
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

	public String getFormat() {
		return format;
	}

	public String getOutputFile() {
		return output_file;
	}

	public String getOutputDir() {
		return output_dir;
	}

	public String getStyle() {
		return style;
	}
	
	//setter
	private void setFormat(String format) {
		this.format = format;
	}

	private void setOutputFile(String output_file) {
		this.output_file = output_file;
	}

	private void setOutputDir(String output_dir) {
		this.output_dir = output_dir;
	}

	private void setStyle(String style) {
		this.style = style;
	}

	private void setInputFile(String input_file) {
		this.input_file = input_file;
	}

	public void accept(MDElementVisitor md){
		md.visit(this);	
	}

}
