package mdconverter;

public class Lines {
	private int lineNum;
	private NodeType lineType;
	private StringBuilder s;
	
	public Lines(){
		this.lineNum = 1;
		this.lineType = NodeType.NONE;
		this.s = new StringBuilder();
	}
	
	public void setLinesType(NodeType code){
		this.lineType = code;
	}
	
	public NodeType getLinesType(){
		return this.lineType;
	}
	
	public int getLineNum(){
		return this.lineNum;
	}
	
	public void append(String st){
		this.s.append(st + "\n");
	}
	
	public String toString(){
		return this.s.toString();	
	}
}
