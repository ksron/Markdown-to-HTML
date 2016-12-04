package util;

import java.util.Iterator;
import java.util.LinkedList;

public class Lines implements Iterable<String>{
	private int lineNum;
	private LinkedList<String> lines;
	private NodeType lineType;
	
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
		lines.add(st + "\n");
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
		String s;
		try{
			s = this.lines.get(i);
		}catch(IndexOutOfBoundsException e){
			return null;
		}
		
		return s;
	}
	
	public void setLine(int index, String s){
		this.lines.set(index, s);
	}
		
	@Override
	public String toString(){
		String s = "";
		for(String temp : lines)
			s += temp;
		
		return s;
	}
	
	@Override
	public Iterator<String> iterator(){
		Iterator<String> it = new Iterator<String>(){

			private int index = 0;
			
			@Override
			public boolean hasNext() {
				return index < lineNum && lineAt(index) != null;
			}

			@Override
			public String next() {
				return lineAt(index++);
			}
		};
		
		return it;
	}
}

