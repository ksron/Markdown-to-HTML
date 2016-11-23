package util;

import java.util.LinkedList;

public class Lines {
	private int lineNum;
	private LinkedList<String> lines;
	private NodeType lineType;
	private int index = 0;
	
	public Lines(){
		this.lineNum = 0;
		this.lineType = NodeType.NONE;
		lines = new LinkedList<>();
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
		this.lineNum++;
		lines.add(st);
	}
	
	public void removeLast(){
		this.lineNum--;
		this.lines.removeLast();
	}
	
	public void remove(int i){
		this.lineNum--;
		this.lines.remove(i);
	}
	
	public LinkedList<String> getLines(){
		return this.lines;
	}
	
	public String lineAt(int i){
		return this.lines.get(i);
	}
	
	public void setLine(int index, String s){
		this.lines.set(index, s);
	}
	
	public String next(){
		try{
			String output = this.lines.get(this.index++);
			return output;
		}catch(IndexOutOfBoundsException e){
			return null;
		}
	}
	
	@Override
	public String toString(){
		String s = "";
		for(String temp : lines)
			s += temp;
		
		return s;
	}
}
