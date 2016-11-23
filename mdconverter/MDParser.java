package mdconverter;

import java.io.*;

import Node.Node;
import util.LineType;
import util.Lines;
import util.NodeType;

public class MDParser {
	
	public MDParser(){
		
	}
	
	public Document parse(Document doc) {
		try {
			BufferedReader in = new BufferedReader(new FileReader(doc.getInputFile()));
			String s = in.readLine();	
						
			while (s != null){
				Lines lines = new Lines();
				LineType type = getLineType(s);
				
				if(type == LineType.CODE){
					lines.setLinesType(NodeType.CODE);
					while(type == LineType.CODE ){
						lines.append(s);
						s = in.readLine();
						type = getLineType(s);
					}
				}
				else if(type == LineType.QUOTED ){
					lines.setLinesType(NodeType.QUOTED);
					while(type == LineType.QUOTED  || type == LineType.BLOCK ){
						lines.append(s);
						s = in.readLine();
						type = getLineType(s);
					}
				}
				else if(type == LineType.UNORDERED ){
					lines.setLinesType(NodeType.UNORDERED_LIST);
					while(type == LineType.UNORDERED  || type == LineType.EMPTY || type == LineType.CODE || type == LineType.BLOCK){
						lines.append(s);
						s = in.readLine();
						if(type == LineType.EMPTY){
							type = getLineType(s);
							if(type != LineType.CODE || type != LineType.UNORDERED )
								break;
						}
						else{
							type = getLineType(s);
						}
					}
				}
				else if(type == LineType.ORDERED ){
					lines.setLinesType(NodeType.ORDERED_LIST);
					while(type == LineType.ORDERED  || type == LineType.EMPTY  || type == LineType.CODE){
						lines.append(s);
						s = in.readLine();
						type = getLineType(s);
					}
				}
				else if(type == LineType.ATX_HEADER ){
					lines.setLinesType(NodeType.HEADER);
					lines.append(s);
					s = in.readLine();
				}
				else if(type == LineType.HR || type == LineType.BAR_LINE ){
					lines.setLinesType(NodeType.HR);
					lines.append(s);
					s = in.readLine();
				}
				else if(type == LineType.LINKADDR ){
					lines.setLinesType(NodeType.LINKADDR);
					lines.append(s);
					s = in.readLine();
				}
				else if(type == LineType.EMPTY ){
					lines.setLinesType(NodeType.EMPTY);
					s = in.readLine();
					continue;
				}
				else if(type == LineType.BLOCK || type == LineType.SETEXT_HEADER){
					lines.setLinesType(NodeType.BLOCK);
					while(type == LineType.BLOCK || ((type == LineType.SETEXT_HEADER|| type == LineType.BAR_LINE)  && lines.getLineNum() != 1) ){
						lines.append(s);
						s = in.readLine();
						type = getLineType(s);
					}
					
					if((type == LineType.SETEXT_HEADER || type == LineType.BAR_LINE) && lines.getLineNum() == 1){
						lines.setLinesType(NodeType.HEADER);
						lines.append(s);
						s = in.readLine();
					}
				}
				else{
					s = in.readLine();
					continue;
				}
				
				doc.updateNode(Node.create(lines));
			}
			
			in.close();
		} catch (IOException e) {
			System.err.println(e);
			System.exit(1);
		}
		return doc;
	}

	private LineType getLineType(String line){
		if(line == null){
			return LineType.EMPTY;
		}
		else if(line.matches(LineType.CODE.pattern)){
			return LineType.CODE;
		}
		else if(line.matches(LineType.QUOTED.pattern)){
			return LineType.QUOTED;
		}
		else if(line.matches(LineType.UNORDERED.pattern)){
			return LineType.UNORDERED;
		}
		else if(line.matches(LineType.ORDERED.pattern)){
			return LineType.ORDERED;
		}
		else if(line.matches(LineType.ATX_HEADER.pattern)){
			return LineType.ATX_HEADER;
		}
		else if(line.matches(LineType.HR.pattern)){
			return LineType.HR;
		}
		else if(line.matches(LineType.SETEXT_HEADER.pattern)){
			return LineType.SETEXT_HEADER;
		}
		else if(line.matches(LineType.BAR_LINE.pattern)){
			return LineType.SETEXT_HEADER;
		}
		else if(line.matches(LineType.LINKADDR.pattern)){
			return LineType.LINKADDR;
		}
		else if(line.matches(LineType.EMPTY.pattern)){
			return LineType.EMPTY;
		}
		else if(line.matches(LineType.BLOCK.pattern)){
			return LineType.BLOCK;
		}
		else{
			return LineType.EMPTY;
		}
	}
}